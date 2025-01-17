package com.example.matulewithstyleguide.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.data.model.ScreenState
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.SubTextLight
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun OnboardTemplate(
    @DrawableRes image: Int,
    label1: String,
    label2: String,
    desc1: String,
    desc2: String,
    currentScreen: ScreenState,
    buttonText: String,
    onClick: ()-> Unit,

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
                        Color(0xFF2B6B8B)
                    )
                )
            )

    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp, top = 80.dp)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(image) ,
                contentDescription = "image",
                modifier = Modifier.size(375.dp, 302.dp),
                contentScale = ContentScale.Fit
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().padding(top = 60.dp)
            ) {
                Text(
                    label1,
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    fontSize = 34.sp,
                    lineHeight = 44.2.sp,
                    color = Block
                )
                Text(
                    label2,
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    fontSize = 34.sp,
                    lineHeight = 44.2.sp,
                    color = Block
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
            ) {
                Text(
                    desc1,
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    color = SubTextLight
                )
                Text(
                    desc2,
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    color = SubTextLight
                )
            }
            ScreenIndicator(
                currentScreen = currentScreen,
                modifier = Modifier.padding(top = 40.dp)
            )
        }
        ButtonWithText(
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, bottom = 36.dp),
            buttonText = buttonText,
            onButtonClick = onClick,
            mainColor = Block,
            secondaryColor = TextColor
        )
    }
}