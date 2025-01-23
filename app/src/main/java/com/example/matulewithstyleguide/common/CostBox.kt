package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.ui.theme.Accent
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.Hint
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun CostBox(
    modifier: Modifier,
    sum: Double,
    deliver: Double,
    fullSum: Double,
    onButtonClick: ()-> Unit,
    color: Color,
    buttonText: String
){
    Box(
        modifier = Modifier.fillMaxWidth().height(258.dp).background(color),
        contentAlignment = Alignment.Center
    ) {
        Column {
            CostRow(
                modifier = Modifier.padding(top = 25.dp),
                label = "Сумма",
                mainColor = Hint,
                costColor = TextColor,
                cost = sum
            )
            CostRow(
                modifier = Modifier.padding(top = 9.dp),
                label = "Доставка",
                mainColor = Hint,
                costColor = TextColor,
                cost = deliver
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.stretch_line),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.fillMaxWidth().padding(top = 23.dp)
            )
            CostRow(
                modifier = Modifier.padding(top = 22.dp),
                label = "Итого",
                mainColor = TextColor,
                costColor = Accent,
                cost = fullSum
            )
            ButtonWithText(
                modifier = Modifier.padding(top = 25.dp),
                onButtonClick = onButtonClick,
                buttonText = buttonText,
                mainColor = Accent,
                secondaryColor = Block
            )
        }
    }
}