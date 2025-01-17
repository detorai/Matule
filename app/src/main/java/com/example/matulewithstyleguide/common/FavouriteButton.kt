package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.ui.theme.Background

@Composable
fun FavouriteButton(
    state: Boolean,
    onClick: ()-> Unit,
    modifier: Modifier
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(28.dp)
            .background(color = Background, shape = RoundedCornerShape(40.dp))
            .clickable {
                onClick()
            }
    ){
        Icon(
            imageVector = ImageVector.vectorResource(if (!state) R.drawable.heart else R.drawable.fill_heart),
            contentDescription = "icon",
            tint = Color.Unspecified
        )
    }
}

