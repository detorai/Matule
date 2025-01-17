package com.example.matulewithstyleguide.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Accent
import com.example.matulewithstyleguide.ui.theme.Background



@Composable
fun ButtonWithText(
    modifier: Modifier,
    onButtonClick: ()-> Unit,
    buttonText: String,
    mainColor: Color,
    secondaryColor: Color
){
    Button(
        modifier = modifier.height(50.dp).fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        onClick = onButtonClick,
        colors = ButtonColors(
            contentColor = secondaryColor,
            containerColor = mainColor,
            disabledContentColor = secondaryColor,
            disabledContainerColor = mainColor
        )
    ) {
        Box(
            contentAlignment = Alignment.Center
        ){
            Text(
                buttonText,
                fontFamily = peninimFont,
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                lineHeight = 22.sp
            )
        }
    }
}