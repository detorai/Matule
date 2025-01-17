package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matulewithstyleguide.ui.theme.Block

@Composable
fun ProductCard(
    modifier: Modifier,
    onAdd: ()-> Unit,
    onFavourite: ()-> Unit,
    state: Boolean
){
    Box(
        modifier = modifier
            .size(160.dp, 182.dp)
            .background(color = Block, shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ){
        AddButton(
            onClick = onAdd,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
        FavouriteButton(
            onClick = onFavourite,
            modifier = Modifier.align(Alignment.TopStart).padding(9.dp),
            state = state
        )
    }
}

@Preview
@Composable
fun check(){
    var state by remember { mutableStateOf(false) }
    ProductCard(
        state = state,
        onFavourite = { state = !state },
        onAdd = {},
        modifier = Modifier
    )
}