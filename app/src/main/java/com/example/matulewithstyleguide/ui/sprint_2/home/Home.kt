package com.example.matulewithstyleguide.ui.sprint_2.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.matulewithstyleguide.common.CategoryLazyRow
import com.example.matulewithstyleguide.common.RowWithClickableText
import com.example.matulewithstyleguide.common.SearchRow
import com.example.matulewithstyleguide.common.TopLabel
import com.example.matulewithstyleguide.ui.theme.Background

@Composable
fun Home(
    state: Boolean,
    onHamburgerClick: ()-> Unit,
    inputText: String,
    onValue: (String) -> Unit,
    categories: List<String>,
    onAll: ()-> Unit
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(color = Background)
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
            modifier = Modifier.padding(top = 22.dp, start = 20.dp)
        )
        RowWithClickableText(
            modifier = Modifier.padding(top = 24.dp, start = 20.dp, end = 20.dp),
            onClick = onAll
        )
    }
}