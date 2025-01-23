package com.example.matulewithstyleguide

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matulewithstyleguide.data.model.Products
import com.example.matulewithstyleguide.data.repository.AuthRepository
import com.example.matulewithstyleguide.data.repository.AuthResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

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

    private val _selectedCategory = MutableStateFlow("")
    val selectedCategory = _selectedCategory.asStateFlow()

    fun selectCategory(category: String){
        _selectedCategory.value = category
        Log.d("category:" ,"$category, ${_selectedCategory.value}")
    }

    //sprint 3


    //sprint 4
    private val _nameTextSU = MutableStateFlow("")
    val nameTextSU = _nameTextSU.asStateFlow()

    private val _emailTextSU = MutableStateFlow("")
    val emailTextSU = _emailTextSU.asStateFlow()

    private val _passwordTextSU = MutableStateFlow("")
    val passwordTextSU = _passwordTextSU.asStateFlow()

    private val _viewStateSU = MutableStateFlow(false)
    val viewStateSU = _viewStateSU.asStateFlow()

    private val _checkState = MutableStateFlow(false)
    val checkState = _checkState.asStateFlow()


    fun onNameChangeSU(name:String){
        _nameTextSU.value = name
    }

    fun onEmailChangeSU(email: String){
        _emailTextSU.value = email
    }

    fun onPasswordChangeSU(password: String){
        _passwordTextSU.value = password
    }

    fun viewStateChangeSU(){
        _viewStateSU.value = !_viewStateSU.value
    }

    fun onCheckState(){
        _checkState.value = !checkState.value
    }

    private val _emailTextFP = MutableStateFlow("")
    val emailTextFP = _emailTextFP.asStateFlow()

    fun onEmailChangeFP(email: String){
        _emailTextFP.value = email
    }

    private val _showDialog = MutableStateFlow(false)
    val showDialog = _showDialog.asStateFlow()

    fun onPopup(){
        _showDialog.value = !_showDialog.value
    }


    private var _codeText = List(6) { MutableStateFlow("") }
    var codeText = _codeText.map { it.asStateFlow() }

    var codeOTP = mutableStateOf<List<Int>>(emptyList())



    fun onCodeChange(index: Int, text: String) {
        if (index in _codeText.indices) {
            _codeText[index].value = text
        }
    }

    private fun genOTP(size: Int = 6, range: IntRange = 0..9): List<Int> {
        return List(size) { Random.nextInt(range.first, range.last + 1)}
    }

    fun sendOTP(email: String){
        codeOTP.value = genOTP()
        _emailTextFP.value = email
        Log.d("OTP CODE", "email:$email\nOTP Code:${codeOTP.value.joinToString { it.toString() }}")
    }


    private val _emailInfo = MutableStateFlow("")
    val emailInfo = _emailInfo.asStateFlow()

    private val _phoneInfo = MutableStateFlow("")
    val phoneInfo = _phoneInfo.asStateFlow()

    private val _addressInfo = MutableStateFlow("")
    val addressInfo = _addressInfo.asStateFlow()

    private val _sum = MutableStateFlow(Double)
    val sum = _sum.asStateFlow()

    private val _fullSum = MutableStateFlow(Double)
    val fullSum = _fullSum.asStateFlow()

    private val _delivery = MutableStateFlow(Double)
    val delivery = _delivery.asStateFlow()

    fun onEmailInfo(){

    }
    fun onPhoneInfo(){

    }
    fun onAddressInfo(){

    }

//    private fun fullSumCalc(): Double{
//        return (_sum.value  _delivery.value)
//    }
}