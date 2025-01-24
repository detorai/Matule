package com.example.matulewithstyleguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import cafe.adriel.voyager.navigator.Navigator
import com.example.matulewithstyleguide.di.appModule
import com.example.matulewithstyleguide.ui.sprint_1.SignInScreen
import com.example.matulewithstyleguide.ui.sprint_2.catalog.CatalogScreen
import com.example.matulewithstyleguide.ui.sprint_2.home.HomeScreen
import com.example.matulewithstyleguide.ui.sprint_2.onboard_1.OnboardScreen1
import com.example.matulewithstyleguide.ui.sprint_2.onboard_2.OnboardScreen2
import com.example.matulewithstyleguide.ui.sprint_2.onboard_3.OnboardScreen3
import com.example.matulewithstyleguide.ui.sprint_2.popular.PopularScreen
import com.example.matulewithstyleguide.ui.sprint_4.checkout.CheckoutScreen
import com.example.matulewithstyleguide.ui.sprint_4.sign_up.SignUpScreen
import com.example.matulewithstyleguide.ui.sprint_4.verification.VerificationScreen
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.viewmodel.factory.KoinViewModelFactory

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<SupabaseViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        startKoin{
            modules(appModule)
        }

        val sprint2 = listOf(
            PopularScreen(viewModel),
            CatalogScreen(viewModel),
            HomeScreen(viewModel),
            OnboardScreen3(viewModel),
            OnboardScreen2(viewModel),
            OnboardScreen1(viewModel),
        )

        setContent {
                Navigator(HomeScreen(viewModel))
        }
    }
}
