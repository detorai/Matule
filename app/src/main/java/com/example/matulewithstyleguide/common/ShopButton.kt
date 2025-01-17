package com.example.matulewithstyleguide.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun ShopButton(
    state: Boolean
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(44.dp)
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.rectangle_797),
            contentDescription = "icon",
            tint = Color.Unspecified
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.bag_2),
            contentDescription = "icon",
            modifier = Modifier.size(24.dp),
            tint = TextColor
        )
        if (state){
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.shop_state),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.padding(bottom = 32.dp, start = 31.dp)
            )
        }
    }
}

