package com.example.matulewithstyleguide.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.ui.theme.SubTextDark

@Composable
fun TextClick(
    onClickText: ()-> Unit,
    modifier: Modifier
){
    val annotatedText = buildAnnotatedString {
        pushStringAnnotation("click", "clickable")
        withStyle(
            SpanStyle(
                color = SubTextDark,
                fontWeight = FontWeight.W400,
                fontSize = 14.sp
            )
        ) {
            append("Восстановить")
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = modifier.fillMaxWidth().wrapContentHeight()
    ) {
        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(offset, offset).firstOrNull()
                    ?.let { annotation ->
                        when (annotation.item) {
                            "clickable" -> onClickText()
                        }
                    }
            }
        )
    }
}