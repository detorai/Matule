package com.example.matulewithstyleguide.data

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.FlowType
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage

object SupabaseModule {
    fun SupabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://thaebjriqgthygwjzpxk.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRoYWVianJpcWd0aHlnd2p6cHhrIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzY4NTI0NDYsImV4cCI6MjA1MjQyODQ0Nn0.xvfhjNmDK1vKxoiV_XlnE9J59BHAapPOcU1fLDxoUvE"
        ) {
            install(Postgrest)
            install(Auth) {
                flowType = FlowType.PKCE
                scheme = "app"
                host = "supabase.com"
            }
            install(Storage)
        }
    }
    fun supabaseDatabase(client: SupabaseClient): Postgrest {
        return client.postgrest
    }

    fun supabaseAuth(client: SupabaseClient): Auth {
        return client.auth
    }

    fun supabaseStorage(client: SupabaseClient): Storage {
        return client.storage
    }
}