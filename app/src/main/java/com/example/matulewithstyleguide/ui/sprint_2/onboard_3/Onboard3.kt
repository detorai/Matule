package com.example.matulewithstyleguide.ui.sprint_2.onboard_3

import androidx.compose.runtime.Composable
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.common.OnboardTemplate
import com.example.matulewithstyleguide.data.model.ScreenState

@Composable
fun Onboard3(
    onClick: ()-> Unit
){
    OnboardTemplate(
        image = R.drawable.image_3,
        label1 = "У Вас Есть Сила,",
        label2 = "Чтобы",
        desc1 = "В вашей комнате много красивых и",
        desc2 = "привлекательных растений",
        currentScreen = ScreenState.third,
        buttonText = "Далее",
        onClick = onClick
    )
}