package com.example.matulewithstyleguide.ui.sprint_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.ui.theme.Accent

@Composable
fun Splash(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Accent)
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.rectangle_797),
            contentDescription = "icon",
            tint = Color.Unspecified
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.bag_2),
            contentDescription = "icon",
            tint = Color.Unspecified
        )
    }
}