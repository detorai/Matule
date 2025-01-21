package com.example.matulewithstyleguide.ui.sprint_4.verification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.common.ButtonBack
import com.example.matulewithstyleguide.common.ClickableTimer
import com.example.matulewithstyleguide.common.FullBoxTextField
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.SubTextDark
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun Verification(
    onClickBack: ()-> Unit,
    codeText: List<String>,
    onCode: (Int,String)-> Unit,
    onSend: ()-> Unit
){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Block)
            .padding(horizontal = 20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 66.dp)
        ) {
            ButtonBack(
                onClickBack = onClickBack,
                modifier = Modifier
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Text(
                    "ОТР Проверка",
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    fontSize = 32.sp,
                    lineHeight = 32.75.sp,
                    color = TextColor
                )
                Text(
                    "Пожалуйста, Проверьте Свою\nЭлектронную Почту, Чтобы Увидеть Код\nПодтверждения",
                    color = SubTextDark,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    lineHeight = 24.sp,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
            Text(
                "OTP Код",
                fontFamily = peninimFont,
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                color = TextColor,
                modifier = Modifier.padding(top = 16.dp)
            )
            FullBoxTextField(
                numFields = 6,
                modifier = Modifier.padding(top = 20.dp),
                codeText = codeText,
                onValueChange = onCode,
            )
            ClickableTimer(
                modifier = Modifier.padding(top = 20.dp),
                onClick = onSend
            )
        }
    }
}

