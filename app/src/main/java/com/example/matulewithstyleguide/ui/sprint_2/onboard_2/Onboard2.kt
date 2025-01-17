package com.example.matulewithstyleguide.ui.sprint_2.onboard_2

import androidx.compose.runtime.Composable
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.common.OnboardTemplate
import com.example.matulewithstyleguide.data.model.ScreenState

@Composable
fun Onboard2(
    onClick: ()-> Unit
){
    OnboardTemplate(
        image = R.drawable.image_2,
        label1 = "Начнем",
        label2 = "путешествие",
        desc1 = "Умная, великолепная и модная",
        desc2 = "коллекция Изучите сейчас",
        currentScreen = ScreenState.second,
        buttonText = "Далее",
        onClick = onClick,
    )
}