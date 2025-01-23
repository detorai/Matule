package com.example.matulewithstyleguide.ui.sprint_3.favourite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.common.LabelRow
import com.example.matulewithstyleguide.common.ProductCard
import com.example.matulewithstyleguide.data.model.Products
import com.example.matulewithstyleguide.ui.theme.Background

@Composable
fun Favourite(
    onBack:() -> Unit,
    onFavour: ()-> Unit,
    products: List<Products>,
    onFavourite: (Int)-> Unit,
    onAdd:(Int)-> Unit
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(color = Background).padding(20.dp, 48.dp)
    ) {
        LabelRow(
            onClickBack = onBack,
            onFavour = onFavour,
            modifier = Modifier,
            heart = R.drawable.fill_heart,
            label = "Избранное"
        )
        LazyVerticalGrid(
            columns = GridCells.FixedSize(160.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
        ) {
            items(products.size) { index ->
                ProductCard(
                    products = products[index],
                    onFavourite = { onFavourite(index) },
                    onAdd = {
                        onAdd(index)
                    },
                    state = products[index].favourState,
                    addState = products[index].addState
                )
            }
        }
    }
}