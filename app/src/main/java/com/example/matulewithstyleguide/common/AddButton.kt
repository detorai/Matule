package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun AddButton(
    modifier: Modifier,
    onClick: () -> Unit
){
    Box(
        modifier = modifier
            .size(34.dp)
            .background(color = Accent, shape = RoundedCornerShape(16.dp))
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.plus),
            contentDescription = "",
            tint = Color.Unspecified
        )
    }
}