package com.example.matulewithstyleguide.data.model

data class Users(
    val name: String,
    val email: String,
    val password: String,
    val salt: ByteArray
)
