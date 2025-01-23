package com.example.matulewithstyleguide.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.data.model.SwipeableState
import com.example.matulewithstyleguide.ui.theme.Background
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.Red
import com.example.matulewithstyleguide.ui.theme.TextColor
import kotlin.math.roundToInt

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
    var offsetX by remember { mutableStateOf(0f) }
    val swipeableState = rememberSwipeableState(initialValue = SwipeableState.DEFAULT)

    val buttonWidth = 58.dp
    val buttonSpacing = 10.dp
    val density = LocalDensity.current

    val anchors = mapOf(
        0f to SwipeableState.DEFAULT,
        with(density) { buttonWidth.toPx() + buttonSpacing.toPx() } to SwipeableState.COUNT,
        with(density) { -(buttonWidth.toPx() + buttonSpacing.toPx()) } to SwipeableState.DELETE
    )
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(104.dp)
            .background(color = Block, shape = RoundedCornerShape(8.dp))
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal,
                resistance = null
            )
            .offset { IntOffset(offsetX.roundToInt(), 0) }
            .onGloballyPositioned { layoutCoordinates ->
                offsetX = layoutCoordinates.size.width.toFloat() * swipeableState.offset.value
            }
    ) {
        if (swipeableState.currentValue == SwipeableState.DELETE) {
            Box(
                modifier = Modifier
                    .size(buttonWidth, 104.dp)
                    .background(color = Red, shape = RoundedCornerShape(8.dp))
                    .align(Alignment.CenterEnd)
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
        if (swipeableState.currentValue == SwipeableState.COUNT) {
            Column(
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(buttonWidth, 104.dp)
                        .clickable(onClick = onUp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("+", color = Color.White)
                }
                Text(
                    "$countProduct",

                    )
                Box(
                    modifier = Modifier
                        .size(buttonWidth, 104.dp)
                        .clickable(onClick = onDown),
                    contentAlignment = Alignment.Center
                ) {
                    Text("-", color = Color.White)
                }
            }
        }
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
            modifier = Modifier.align(Alignment.CenterStart).padding(start = 127.dp).height(39.dp)
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

@Preview
@Composable
fun check(){
    CartProductCard(
        modifier= Modifier,
        label= "Nike",
        cost = 412.12,
        onDelete ={},
        onUp={},
        onDown={},
        countProduct = 3
    )
}
