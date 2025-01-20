package com.example.matulewithstyleguide.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Accent
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun RowWithClickableText(
    modifier: Modifier,
    onClick : ()-> Unit,
    text: String
){
    val annotatedText = buildAnnotatedString {
        pushStringAnnotation("click", "clickable")
        withStyle(
            SpanStyle(
                fontFamily = peninimFont,
                color = Accent,
                fontWeight = FontWeight.W400,
                fontSize = 12.sp
            )
        ) {
            append("Все")
        }
        pop()
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text,
            fontFamily = peninimFont,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            lineHeight = 16.38.sp,
            color = TextColor
        )
        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(offset, offset).firstOrNull()
                    ?.let { annotation ->
                        when (annotation.item) {
                            "clickable" -> onClick()
                        }
                    }
            }
        )
    }
}