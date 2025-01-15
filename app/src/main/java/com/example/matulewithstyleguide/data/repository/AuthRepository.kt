package com.example.matulewithstyleguide.data.repository

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Boolean
    suspend fun signUp(email: String, password: String): Boolean
    suspend fun signInWithGoogle(): Boolean
}