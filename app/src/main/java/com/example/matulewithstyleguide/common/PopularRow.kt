package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun PopularRow(
    onClickBack: ()-> Unit,
    onFavour: ()-> Unit,
    modifier: Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
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
            "Популярное",
            fontFamily = peninimFont,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.W400,
            color = TextColor,
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .size(44.dp)
                .background(color = Block, shape = RoundedCornerShape(40.dp))
                .clickable {
                    onFavour()
                }
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.heart),
                contentDescription = "icon",
                tint = Color.Unspecified,
                modifier = Modifier.size(18.dp,16.dp)
            )
        }
    }
}

@Preview
@Composable
fun check(){
    PopularRow(
        modifier = Modifier,
        onFavour = {},
        onClickBack = {}
    )
}