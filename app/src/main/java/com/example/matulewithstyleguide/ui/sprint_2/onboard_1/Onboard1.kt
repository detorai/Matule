package com.example.matulewithstyleguide.ui.sprint_2.onboard_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.common.ButtonWithText
import com.example.matulewithstyleguide.common.ScreenIndicator
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.data.model.ScreenState
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun Onboard1(
    currentScreen: ScreenState,
    onClick: ()-> Unit
){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Brush.linearGradient(
                colors = listOf(
                    Color(0xFF48B2E7),
                    Color(0xFF44A9DC),
                    Color(0xFF2B6B8B)
                )
            )
        )

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(top = 70.dp)
        ) {
            Text(
                "ДОБРО",
                fontFamily = peninimFont,
                fontWeight = FontWeight.W400,
                fontSize = 30.sp,
                lineHeight = 30.7.sp,
                color = Block
            )
            Text(
                "ПОЖАЛОВАТЬ",
                fontFamily = peninimFont,
                fontWeight = FontWeight.W400,
                fontSize = 30.sp,
                lineHeight = 30.7.sp,
                color = Block
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(top = 130.dp)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.image_1) ,
                contentDescription = "image",
                modifier = Modifier.size(375.dp, 302.dp),
                contentScale = ContentScale.Fit
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                ScreenIndicator(
                    currentScreen = currentScreen,
                    modifier = Modifier.padding(bottom = 81.dp)
                )
            }
        }

        ButtonWithText(
            modifier = Modifier.padding(bottom = 36.dp, start = 20.dp , end = 20.dp ),
            onButtonClick = onClick,
            mainColor = Block,
            secondaryColor = TextColor,
            buttonText = "Начать"
        )
    }
}