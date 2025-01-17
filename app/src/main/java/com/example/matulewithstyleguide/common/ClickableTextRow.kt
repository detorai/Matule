package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.ui.sprint_1.peninimFont
import com.example.matulewithstyleguide.ui.theme.Hint
import com.example.matulewithstyleguide.ui.theme.Text

@Composable
fun ClickableTextRow(
    nonClickable: String,
    clickable: String,
    onClick: () -> Unit,
    modifier: Modifier
){
    val annotatedText = buildAnnotatedString {
        withStyle(
            SpanStyle(
                fontFamily = peninimFont,
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                color = Hint
            )
        ) {
            append(nonClickable)
        }
        pushStringAnnotation("click", "clickable")
        withStyle(
            SpanStyle(
                fontFamily = peninimFont,
                color = Text,
                fontWeight = FontWeight.W400,
                fontSize = 16.sp
            )
        ) {
            append(clickable)
        }
        pop()
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
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