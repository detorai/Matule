package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matulewithstyleguide.data.model.ScreenState
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.Disable


@Composable
fun ScreenIndicator(currentScreen: ScreenState){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        val screens = ScreenState.entries.toTypedArray()
        screens.forEachIndexed { index, screen ->
            val isSelected = screen == currentScreen
            Box(
                modifier = Modifier
                    .width(if (isSelected) 48.dp else 23.dp)
                    .height(3.dp)
                    .background(
                        color =(if (isSelected) Block else Disable),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(4.dp),

            )
            if (index < screens.lastIndex) {
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}
@Preview
@Composable
fun checkState(){
    ScreenIndicator(ScreenState.second)
}