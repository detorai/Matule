package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun SearchView(
    onClickBack:()-> Unit,
    inputText: String,
    onValue: (String)-> Unit
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxSize().background(color = Background)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier.fillMaxWidth().padding(top = 48.dp)
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
                "Поиск",
                fontFamily = peninimFont,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.W400,
                color = TextColor,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        SearchBar(
            inputText = inputText,
            onValue = onValue,
            placeholder = "Поиск",
            modifier = Modifier.padding(top = 26.dp),
            state = true
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier.fillMaxWidth().padding(top = 28.dp)
        ) {

        }
    }
}