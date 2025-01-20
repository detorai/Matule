package com.example.matulewithstyleguide.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.data.model.Products
import com.example.matulewithstyleguide.ui.theme.Accent
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.Hint
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun ProductCard(
    onAdd: ()-> Unit,
    onFavourite: ()-> Unit,
    state: Boolean,
    products: Products,
    addState: Boolean,
){
    Box(
        modifier = Modifier
            .size(160.dp, 182.dp)
            .background(color = Block, shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ){
        AddButton(
            onClick = onAdd,
            modifier = Modifier.align(Alignment.BottomEnd),
            state = addState
        )
        FavouriteButton(
            onClick = onFavourite,
            modifier = Modifier.align(Alignment.TopStart).padding(9.dp),
            state = state
        )
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.nike_zoom),
            contentDescription = "",
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 18.dp).size(118.dp , 70.dp)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth().wrapContentHeight().align(Alignment.BottomCenter).padding(start = 9.dp, end = 9.dp, bottom = 38.dp)
        ) {
            Text(
                "BEST SELLER",
                fontSize = 12.sp,
                fontFamily = peninimFont,
                fontWeight = FontWeight.W400,
                lineHeight = 16.sp,
                color = Accent
            )
            Text(
                "Nike Air Max",
                fontSize = 16.sp,
                fontFamily = peninimFont,
                fontWeight = FontWeight.W400,
                lineHeight = 20.sp,
                color = Hint,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Text(
            "₽752.00",
            fontSize = 14.sp,
            fontFamily = peninimFont,
            fontWeight = FontWeight.W400,
            lineHeight = 16.sp,
            color = TextColor,
            modifier = Modifier.align(Alignment.BottomStart).padding(start = 9.dp, bottom = 8.dp )
        )
    }
}

