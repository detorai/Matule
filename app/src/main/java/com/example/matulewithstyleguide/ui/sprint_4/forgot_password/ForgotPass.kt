package com.example.matulewithstyleguide.ui.sprint_4.forgot_password

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.common.ButtonBack
import com.example.matulewithstyleguide.common.ButtonWithText
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Accent
import com.example.matulewithstyleguide.ui.theme.Background
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.Hint
import com.example.matulewithstyleguide.ui.theme.SubTextDark
import com.example.matulewithstyleguide.ui.theme.SubTextLight
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun ForgotPass(
    onClickBack: ()-> Unit,
    emailText: String,
    onEmailChange: (String)-> Unit,
    onButtonClick: ()-> Unit,
    showDialog: Boolean,
    onPopup: ()-> Unit
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
                    "Забыл Пароль",
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    fontSize = 32.sp,
                    lineHeight = 32.75.sp,
                    color = TextColor
                )
                Text(
                    "Введите свою учетную запись",
                    color = SubTextDark,
                    fontSize = 16.sp,
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    lineHeight = 24.sp,
                    modifier = Modifier.padding(top = 8.dp),
                )
                Text(
                    "Для Сброса",
                    color = SubTextDark,
                    fontSize = 16.sp,
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    lineHeight = 24.sp
                )
            }
            OutlinedTextField(
                value = emailText,
                onValueChange = onEmailChange,
                placeholder = {
                    Text(
                        "xyz@gmail.com",
                        fontFamily = peninimFont,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Hint
                    )
                },
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .padding(top = 40.dp)
                    .height(48.dp)
                    .fillMaxWidth()
                    .background(color = Background),
            )
            ButtonWithText(
                modifier = Modifier.padding(top = 54.dp),
                onButtonClick = onButtonClick,
                buttonText = "Отправить",
                mainColor = Accent,
                secondaryColor = Background
            )
        }
    }
    if (showDialog) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x1B1E2833))
                .clickable { onPopup() }

        )

        Dialog(
            onDismissRequest = { onPopup() }
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(196.dp)
                    .background(color = Block, shape = RoundedCornerShape(16.dp)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .size(44.dp)
                        .background(color = Accent, shape = RoundedCornerShape(40.dp))
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.email_1),
                        contentDescription = "icon",
                        tint = Color.Unspecified,
                    )
                }
                Text(
                    "Проверьте Ваш Email",
                    fontWeight = FontWeight.W400,
                    fontFamily = peninimFont,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = TextColor,
                    modifier = Modifier.padding(top = 24.dp)
                )
                Text(
                    "Мы Отправили Код Восстановления\nПароля На Вашу Электронную Почту.",
                    fontWeight = FontWeight.W400,
                    fontFamily = peninimFont,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = SubTextDark,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp, start = 10.dp, end = 10.dp),
                    maxLines = 2
                )
            }
        }
    }
}