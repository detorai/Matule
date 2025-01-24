package com.example.matulewithstyleguide.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun HistoryRow(
    itemHistory: String
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.clock),
            contentDescription = "",
            tint = Color.Unspecified
        )
        Text(
            itemHistory,
            fontFamily = peninimFont,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 16.sp,
            color = TextColor,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}