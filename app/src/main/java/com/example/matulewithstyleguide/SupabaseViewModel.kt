package com.example.matulewithstyleguide

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matulewithstyleguide.data.model.Products
import com.example.matulewithstyleguide.data.repository.AuthRepository
import com.example.matulewithstyleguide.data.repository.AuthResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SupabaseViewModel(private val authRep: AuthRepository): ViewModel() {

    //Sprint 1

    private val _emailText = MutableStateFlow("")
    val emailText = _emailText.asStateFlow()

    private val _passwordText = MutableStateFlow("")
    val passwordText = _passwordText.asStateFlow()

    private val _viewState = MutableStateFlow(false)
    val viewState = _viewState.asStateFlow()

    fun onEmailChange(email: String){
        _emailText.value = email
    }

    fun onPasswordChange(password: String){
        _passwordText.value = password
    }

    fun viewStateChange(){
        _viewState.value = !_viewState.value
    }

    fun signIn(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            when (val result = authRep.signIn(email, password)) {
                is AuthResult.Success -> {
                    Log.d("SupabaseSignIn", "Успешный вход")
                }
                is AuthResult.Failure -> {
                    Log.e("SupabaseSignIn", "Ошибка: ${result.message}")
                }
            }
        }
    }

    // Sprint 2

    private val _products = MutableStateFlow<List<Products>>(emptyList())
    val products: StateFlow<List<Products>> = _products.asStateFlow()

    fun countProducts(count: Int){
        viewModelScope.launch {
            val newProducts = List(count) { Products() }
            _products.value = newProducts
        }
    }
    fun onFavourite(index: Int) {
        _products.value = _products.value.mapIndexed { idx, product ->
            if (idx == index) {
                product.copy(
                    favouriteButton = !product.favouriteButton,
                    favourState = !product.favourState
                )
            } else {
                product
            }
        }
    }

    fun onAdd(index: Int) {
        _products.value = _products.value.mapIndexed { idx, product ->
            if (idx == index) {
                product.copy(
                    addButton = !product.addButton,
                    addState = true
                )
            } else {
                product
            }
        }
    }

    fun onCart(){
        if (!_shopState.value){
        _shopState.value = !_shopState.value
        }
    }


    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    fun onSearchChange(value: String){
        _searchText.value = value
    }

    private val _shopState = MutableStateFlow(false)
    val shopState = _shopState.asStateFlow()

    val categories = listOf("Все", "Outdoor", "Tennis", "Running")
}