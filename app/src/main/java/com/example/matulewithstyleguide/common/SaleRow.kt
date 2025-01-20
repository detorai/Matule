package com.example.matulewithstyleguide.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.TextColor
import org.intellij.lang.annotations.JdkConstants

@Composable
fun SaleRow(
    modifier: Modifier
){
    Box(
        modifier = modifier.fillMaxWidth().height(95.dp).background(color = Block, shape = RoundedCornerShape(16.dp))
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.star),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 4.dp, end = 63.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.star),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 12.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.star),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.align(Alignment.BottomStart).padding(bottom = 18.dp, start = 8.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.star),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.align(Alignment.TopEnd).padding(top = 15.dp, end = 10.dp)
        )
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.image_2),
            contentDescription = "",
            modifier = Modifier.align(Alignment.CenterEnd).padding(end = 55.dp).size(120.dp, 104.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.misc_06),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 12.dp, start = 48.dp)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.align(Alignment.CenterStart).padding(start = 22.dp).height(55.dp).wrapContentWidth()
        ) {
            Text(
                "Summer Sale",
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                color = TextColor
            )
            Text(
                "15% OFF",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.W900 ,
                fontSize = 36.sp,
                lineHeight = 36.72.sp,
                color = Color(0xFF674DC5),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

