package com.example.matulewithstyleguide.data.repository

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.providers.Google
import io.github.jan.supabase.auth.providers.builtin.Email

class AuthRepositoryImpl(private val auth: Auth): AuthRepository {
    override suspend fun signIn(email: String, password: String): AuthResult {
        return try {
            auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
            AuthResult.Success
        } catch (e: Exception) {
            AuthResult.Failure(e.message ?: "HA-HA")
        }
    }

    override suspend fun signUp(email: String, password: String): AuthResult {
        return try {
            auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
            AuthResult.Success
        } catch (e: Exception) {
            AuthResult.Failure(e.message ?: "HA-HA")
        }
    }

    override suspend fun signInWithGoogle(): AuthResult {
        return try {
            auth.signInWith(Google)
            AuthResult.Success
        } catch (e: Exception) {
            AuthResult.Failure(e.message ?: "HA-HA")
        }
    }
}
