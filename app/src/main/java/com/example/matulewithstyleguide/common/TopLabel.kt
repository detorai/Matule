package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.ui.theme.Background

@Composable
fun TopLabel(
    state: Boolean,
    modifier: Modifier,
    onHamburgerClick: ()-> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth().wrapContentHeight().background(color = Background)
    ) {
        IconButton(
            onClick = onHamburgerClick
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.hamburger),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }
        MainLabel()
        ShopButton(
            state = state
        )
    }
}


