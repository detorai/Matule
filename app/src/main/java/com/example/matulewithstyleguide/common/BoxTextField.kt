package com.example.matulewithstyleguide.common

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.matulewithstyleguide.ui.theme.Background

@Composable
fun BoxTextField(
    inputText: String,
    onValueChange: (String) -> Unit,
    onNextFocus: () -> Unit,
    modifier: Modifier,
    focusRequester: FocusRequester,
){
    BasicTextField(
        value = inputText,
        onValueChange = { it ->
            if (it.length <= 1 && (it.all { it.isDigit() } || it.isEmpty())) {
                onValueChange(it)
            }
            if (it.length == 1) {
                onNextFocus()
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            Box(
                modifier = modifier
                    .size(46.dp, 99.dp)
                    .background(color = Background, shape = RoundedCornerShape(12.dp))
                    .focusable(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    inputText
                )
            }
        }
    )
}


@SuppressLint("AutoboxingStateCreation")
@Composable
fun FullBoxTextField(
    numFields: Int = 6,
    modifier: Modifier,
    codeText: List<String>,
    onValueChange: (Int, String) -> Unit,
) {
    val focusRequesters = List(numFields) { FocusRequester() }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until numFields) {
            BoxTextField(
                inputText = codeText[i],
                onValueChange = { newValue -> onValueChange(i, newValue) },
                onNextFocus = {
                    if (i < numFields - 1){
                        focusRequesters[i + 1].requestFocus()
                    }
                },
                modifier = Modifier.focusRequester(focusRequesters[i]),
                focusRequester = focusRequesters[i],
            )
        }
    }
}