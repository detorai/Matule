package com.example.matulewithstyleguide.di

import com.example.matulewithstyleguide.SupabaseViewModel
import com.example.matulewithstyleguide.data.SupabaseModule
import com.example.matulewithstyleguide.data.SupabaseModule.client
import com.example.matulewithstyleguide.data.repository.AuthRepository
import com.example.matulewithstyleguide.data.repository.AuthRepositoryImpl
import io.github.jan.supabase.auth.auth
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {client.auth}
    single<AuthRepository> {AuthRepositoryImpl(get())}
    viewModel { SupabaseViewModel(get()) }
}