package com.example.matulewithstyleguide.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.data.model.SwipeableState
import com.example.matulewithstyleguide.ui.theme.Accent
import com.example.matulewithstyleguide.ui.theme.Background
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.Red
import com.example.matulewithstyleguide.ui.theme.TextColor
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun CartProductCard(
    modifier: Modifier,
    label: String,
    cost: Double,
    onDelete: ()-> Unit,
    onUp: ()-> Unit,
    onDown: ()-> Unit,
    countProduct: Int
){
    val swappableState = rememberSwipeableState(initialValue = SwipeableState.DEFAULT)
    val width = 56.dp
    val decor = LocalDensity.current

    val anchors = mapOf(
        0f to SwipeableState.DEFAULT,
        with (decor) {width.toPx() } to SwipeableState.COUNT,
        with (decor) {-(width.toPx())} to SwipeableState.DELETE
    )
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(104.dp)
            .swipeable(
                state = swappableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal,
                resistance = null
            )
    ) {
        if (swappableState.currentValue == SwipeableState.COUNT) {
            Box(
                modifier = Modifier
                    .width(width)
                    .height(104.dp)
                    .background(color = Accent, shape = RoundedCornerShape(8.dp))
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 14.dp)
                        .size(15.dp)
                        .clickable(onClick = onUp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.pluscount),
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(14.dp)
                    )
                }
                Text(
                    "$countProduct",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 14.33.sp,
                    modifier = Modifier.align(Alignment.Center),
                    color = Block
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 14.dp)
                        .size(15.dp)
                        .clickable(onClick = onDown),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.minus),
                        contentDescription = "",
                        tint = Color.Unspecified
                    )
                }
            }
            Spacer(Modifier.padding(start = 10.dp))
        }
        if (swappableState.currentValue == SwipeableState.DELETE) {
            Box(
                modifier = Modifier
                    .width(width)
                    .height(104.dp)
                    .background(color = Red, shape = RoundedCornerShape(8.dp))
                    .clickable(onClick = onDelete),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.trash),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(104.dp)
                .background(color = Block, shape = RoundedCornerShape(8.dp))
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 10.dp)
                    .size(87.dp, 85.dp)
                    .background(color = Background, shape = RoundedCornerShape(16.dp))
            ){
                Image(
                    bitmap = ImageBitmap.imageResource(R.drawable.nike_epic),
                    contentDescription = "",
                    modifier = Modifier.size(86.dp, 55.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 127.dp)
                    .height(39.dp)
            ) {
                Text(
                    label,
                    fontFamily = peninimFont,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 16.38.sp,
                    color = TextColor
                )
                Text(
                    "₽$cost",
                    fontFamily = peninimFont,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 14.33.sp,
                    color = TextColor
                )
            }
        }

    }
}



@Preview
@Composable
fun check(){
    var count by remember { mutableIntStateOf(0) }
    CartProductCard(
        modifier= Modifier,
        label= "Nike",
        cost = 412.12,
        onDelete ={},
        onUp={count++},
        onDown={count--},
        countProduct = count
    )
}
