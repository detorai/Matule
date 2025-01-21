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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.ui.theme.Background
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun ButtonBack(
    onClickBack: ()-> Unit,
    modifier: Modifier
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(44.dp)
            .background(color = Background, shape = RoundedCornerShape(40.dp))
            .clickable {
                onClickBack()
            }
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.direction_left),
            contentDescription = "icon",
            tint = TextColor,
        )
    }
}