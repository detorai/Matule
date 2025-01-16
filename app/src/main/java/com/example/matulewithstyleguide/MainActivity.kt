package com.example.matulewithstyleguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.navigator.Navigator
import com.example.matulewithstyleguide.di.appModule
import com.example.matulewithstyleguide.ui.sprint_1.SignInScreen
import com.example.matulewithstyleguide.ui.sprint_2.SplashScreen
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        startKoin{
            modules(appModule)
        }
        setContent {
                Navigator(SignInScreen())
        }
    }
}
