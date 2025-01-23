package com.example.matulewithstyleguide.ui.sprint_2.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.common.CategoryLazyRow
import com.example.matulewithstyleguide.common.ProductCard
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.data.model.Products
import com.example.matulewithstyleguide.ui.theme.Background
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun Catalog(
    onClickBack:()->Unit,
    categories: List<String>,
    products: List<Products>,
    onFavourite: (Int)-> Unit,
    onAdd:(Int)-> Unit,
    onClick: (String) -> Unit,
    category: String
){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(color = Background).padding(horizontal = 20.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(top = 48.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 20.dp)
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
                category,
                fontFamily = peninimFont,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.W400,
                color = TextColor,
            )
        }
        CategoryLazyRow(
            categories = categories,
            modifier = Modifier.padding(top = 16.dp),
            onClick = onClick
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