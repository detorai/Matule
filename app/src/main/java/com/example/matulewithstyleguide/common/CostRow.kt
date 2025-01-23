package com.example.matulewithstyleguide.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.data.model.Font.peninimFont

@Composable
fun CostRow(
    modifier: Modifier,
    mainColor: Color,
    costColor: Color,
    label: String,
    cost: Double
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            label,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontFamily = peninimFont,
            fontWeight = FontWeight.W500,
            color = mainColor
        )
        Text(
            "₽${cost}",
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontFamily = peninimFont,
            fontWeight = FontWeight.W500,
            color = costColor
        )
    }
}