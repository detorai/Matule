package com.example.matulewithstyleguide.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.Hint

@Composable
fun SearchBar(
    inputText: String,
    onValue: (String)-> Unit,
    placeholder: String,
    modifier: Modifier
){
    BasicTextField(
        value = inputText,
        modifier = modifier.fillMaxWidth(0.8f).wrapContentHeight(),
        onValueChange = onValue,
        decorationBox = {
            Box(
                modifier = Modifier
                    .height(52.dp)
                    .background(
                        shape = RoundedCornerShape(14.dp),
                        color = Block
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.search_icon),
                    contentDescription = "",
                    tint = Color.Unspecified,
                    modifier = Modifier.align(Alignment.CenterStart).padding(start = 26.dp)
                )
                Text(
                    text = inputText.ifEmpty {
                        placeholder
                    },
                    modifier = Modifier.align(Alignment.CenterStart).padding(start = 62.dp),
                    fontFamily = peninimFont,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    color = Hint,
                )
            }
        }
    )
}