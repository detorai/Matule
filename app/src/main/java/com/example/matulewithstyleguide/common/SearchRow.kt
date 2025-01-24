package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.example.matulewithstyleguide.ui.theme.Background

@Composable
fun SearchRow(
    modifier: Modifier,
    inputText: String,
    onValue: (String)-> Unit,
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth().wrapContentHeight().background(color = Background)
    ) {
        SearchBar(
            inputText = inputText,
            onValue = onValue,
            placeholder = "Поиск",
            modifier = Modifier,
            state = false
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(52.dp)
        ){
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.rectangle_797),
                contentDescription = "icon",
                tint = Accent
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.sliders),
                contentDescription = "icon",
                tint = Color.Unspecified
            )
        }
    }
}

