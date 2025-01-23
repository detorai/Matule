package com.example.matulewithstyleguide.ui.sprint_3.my_cart

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Background
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun MyCart(
    onClickBack:()-> Unit,
    count: Int,

){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxSize().background(color = Background)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth().padding(top = 48.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .size(44.dp)
                        .background(color = Block, shape = RoundedCornerShape(40.dp))
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
                Text(
                    "Корзина",
                    fontFamily = peninimFont,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.W400,
                    color = TextColor,
                )
            }
            Text(
                "$count товара",
                fontFamily = peninimFont,
                fontSize = 16.sp,
                lineHeight = 16.38.sp,
                fontWeight = FontWeight.W400,
                color = TextColor,
                modifier = Modifier.padding(top = 16.dp)
            )

        }
    }
}