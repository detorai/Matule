package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Background
import com.example.matulewithstyleguide.ui.theme.TextColor


@Composable
fun TextFieldRow(
    value: String,
    onValueChange: (String) -> Unit,
    label:String,
    placeholder:@Composable () -> Unit,
    trailingIcon:@Composable () -> Unit,
    modifier: Modifier,
    visual: VisualTransformation = VisualTransformation.None,
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.fillMaxWidth().wrapContentWidth()
    ) {
        Text(
            label,
            fontFamily = peninimFont,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Center,
            color = TextColor,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 12.dp)
        )
        OutlinedTextField(
            visualTransformation = visual,
            value = value,
            onValueChange = onValueChange,
            trailingIcon = trailingIcon,
            placeholder = placeholder,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier.height(48.dp).fillMaxWidth().background(color = Background),
        )
    }
}