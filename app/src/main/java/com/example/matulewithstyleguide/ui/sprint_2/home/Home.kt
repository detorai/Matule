package com.example.matulewithstyleguide.ui.sprint_2.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.matulewithstyleguide.common.CategoryLazyRow
import com.example.matulewithstyleguide.common.ProductCard
import com.example.matulewithstyleguide.common.RowWithClickableText
import com.example.matulewithstyleguide.common.SaleRow
import com.example.matulewithstyleguide.common.SearchRow
import com.example.matulewithstyleguide.common.TopLabel
import com.example.matulewithstyleguide.data.model.Products
import com.example.matulewithstyleguide.ui.theme.Background

@Composable
fun Home(
    state: Boolean,
    onHamburgerClick: ()-> Unit,
    inputText: String,
    onValue: (String) -> Unit,
    categories: List<String>,
    onAllFavour: ()-> Unit,
    onAllSale: ()-> Unit,
    onAdd: (Int)-> Unit,
    onFavourite: (Int)-> Unit,
    products: List<Products>,
    onCart: ()-> Unit,
    onClick: (String)-> Unit
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Background)
    ) {
        TopLabel(
            state = state,
            onHamburgerClick = onHamburgerClick,
            modifier = Modifier.padding(top = 48.dp, start = 20.dp, end = 20.dp)
        )
        SearchRow(
            modifier = Modifier.padding(top = 21.dp, start = 20.dp, end = 20.dp),
            inputText = inputText,
            onValue = onValue
        )
        CategoryLazyRow(
            categories = categories,
            modifier = Modifier.padding(top = 22.dp, start = 20.dp),
            onClick = onClick
        )
        RowWithClickableText(
            modifier = Modifier.padding(top = 24.dp, start = 20.dp, end = 20.dp),
            onClick = onAllFavour,
            text = "Популярное"
        )
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp).fillMaxWidth().height(182.dp)
        ) {
            items(products.size){ index ->
                ProductCard(
                    products = products[index],
                    onFavourite = { onFavourite(index) },
                    onAdd = {
                        onAdd(index)
                        onCart()
                            },
                    state = products[index].favourState,
                    addState = products[index].addState,

                )
            }
        }
        RowWithClickableText(
            modifier = Modifier.padding(top = 29.dp, start = 20.dp, end = 20.dp),
            onClick = onAllSale,
            text = "Акции"
        )
        SaleRow(
            modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp)
        )
    }
}