package com.example.matulewithstyleguide.data.repository

sealed class AuthResult {
    data object Success : AuthResult()
    data class Failure(val message: String) : AuthResult()
}

interface AuthRepository {
    suspend fun signIn(email: String, password: String): AuthResult
    suspend fun signUp(email: String, password: String): AuthResult
    suspend fun signInWithGoogle(): AuthResult
}
