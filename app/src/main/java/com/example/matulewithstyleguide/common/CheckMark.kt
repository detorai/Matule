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
import com.example.matulewithstyleguide.ui.theme.Background

@Composable
fun CheckMark(
    modifier: Modifier,
    state: Boolean,
    onCheck: ()-> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(18.dp)
            .background(color = Background, shape = RoundedCornerShape(6.dp))
            .clickable {
                onCheck()
            }
    ){
        if (state){
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.check_mark),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }
    }
}