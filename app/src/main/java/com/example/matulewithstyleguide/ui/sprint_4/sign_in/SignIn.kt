package com.example.matulewithstyleguide.ui.sprint_4.sign_in

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.common.ButtonWithText
import com.example.matulewithstyleguide.common.TextClick
import com.example.matulewithstyleguide.common.TextFieldRow
import com.example.matulewithstyleguide.ui.theme.Hint
import com.example.matulewithstyleguide.ui.theme.SubTextDark
import com.example.matulewithstyleguide.ui.theme.TextColor
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.common.ButtonBack
import com.example.matulewithstyleguide.common.ClickableTextRow
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Accent
import com.example.matulewithstyleguide.ui.theme.Background
import com.example.matulewithstyleguide.ui.theme.Block




@Composable
fun SignIn(
    emailText: String,
    onEmailChange: (String)-> Unit,

    passwordText: String,
    onPasswordChange: (String)-> Unit,

    viewState: Boolean,
    viewStateChange: () -> Unit,

    onClickText: ()-> Unit,
    onButtonClick: ()-> Unit,
    onCreate: ()-> Unit,
    onClickBack: ()-> Unit
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
                modifier = Modifier.fillMaxWidth().padding(top = 11.dp)
            ) {
                Text(
                    "Привет!",
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    fontSize = 32.sp,
                    lineHeight = 32.75.sp,
                    color = TextColor
                )
                Text(
                    "Заполните Свои Данные Или",
                    color = SubTextDark,
                    fontSize = 16.sp,
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    lineHeight = 24.sp,
                    modifier = Modifier.padding(top = 8.dp),
                )
                Text(
                    "Продолжите Через Социальные Медиа",
                    color = SubTextDark,
                    fontSize = 16.sp,
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    lineHeight = 24.sp
                )
            }
            TextFieldRow(
                value = emailText,
                onValueChange = onEmailChange,
                label = "Email",
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
                trailingIcon = {},
                modifier = Modifier.padding(top = 35.dp)
            )
            TextFieldRow(
                value = passwordText,
                onValueChange = onPasswordChange,
                label = "Пароль",
                placeholder = {
                    Text(
                        "********",
                        fontFamily = peninimFont,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Hint
                    )
                },
                visual =
                if (viewState) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    IconButton(
                        onClick = viewStateChange
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(
                                when (viewState) {
                                    true -> R.drawable.open_eye
                                    false -> R.drawable.close_eye
                                }
                            ),
                            contentDescription = "trailing icon"
                        )
                    }
                },
                modifier = Modifier.padding(top = 35.dp)
            )
            TextClick(
                onClickText = onClickText,
                modifier = Modifier.padding(top = 12.dp)
            )
            ButtonWithText(
                modifier = Modifier.padding(top = 24.dp),
                onButtonClick = onButtonClick,
                buttonText = "Войти",
                mainColor = Accent,
                secondaryColor = Background
            )
        }
        ClickableTextRow(
            clickable = " Создать пользователя",
            nonClickable = "Вы впервые?",
            onClick = onCreate,
            modifier = Modifier.padding(bottom = 50.dp)
        )
    }
}

@Preview
@Composable
fun Check() {
    SignIn(
        emailText = "123",
        onEmailChange = {},
        passwordText ="123",
        onPasswordChange = {  },
        onButtonClick = {
        },
        onClickText = {},
        viewState = true,
        viewStateChange = {},
        onCreate = {},
        onClickBack = {}
    )
}