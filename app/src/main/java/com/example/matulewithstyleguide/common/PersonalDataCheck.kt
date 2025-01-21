package com.example.matulewithstyleguide.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Hint

@Composable
fun PersonalDataCheck(
    state: Boolean,
    onCheck: () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier
){
    val annotatedText = buildAnnotatedString {
        pushStringAnnotation("click", "clickable")
        withStyle(
            SpanStyle(
                fontFamily = peninimFont,
                color = Hint,
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
            )
        ) {
            append("Даю согласие на обработку\nперсональных данных")
        }
        pop()
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.fillMaxWidth()
    ){
        CheckMark(
            onCheck = onCheck,
            state = state,
            modifier = Modifier
        )
        ClickableText(
            text = annotatedText,
            maxLines = 2,
            modifier = Modifier.padding(start = 12.dp),
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