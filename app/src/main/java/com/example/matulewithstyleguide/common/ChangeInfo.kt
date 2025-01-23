package com.example.matulewithstyleguide.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Background
import com.example.matulewithstyleguide.ui.theme.Hint
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun ChangeInfo(
    modifier: Modifier,
    @DrawableRes image: Int,
    info: String,
    onEdit:()-> Unit,
    label: String,
    ifEmpty: String,
    @DrawableRes edit: Int,
    state: Boolean
){
    Box(
      modifier = modifier.fillMaxWidth().height(40.dp)
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(40.dp)
                .background(color = Background, shape = RoundedCornerShape(12.dp))
        ) {
            if (state) {
                Icon(
                    imageVector = ImageVector.vectorResource(image),
                    contentDescription = "icon",
                    tint = TextColor,
                )
            } else {
                Image(
                    bitmap = ImageBitmap.imageResource(image),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp, 22.dp)
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.align(Alignment.CenterStart).padding(start = 52.dp).height(40.dp)
        ) {
            Text(
                text = info.ifEmpty {
                    ifEmpty
                },
                fontSize = 14.sp,
                fontFamily = peninimFont,
                fontWeight = FontWeight.W500,
                lineHeight = 20.sp,
                color = TextColor
            )
            Text(
                label,
                fontSize = 12.sp,
                fontFamily = peninimFont,
                fontWeight = FontWeight.W500,
                lineHeight = 16.sp,
                color = Hint
            )
        }
        Box(
            modifier = Modifier.align(Alignment.CenterEnd).size(20.dp).clickable {
                onEdit()
            },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(edit),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }
    }
}

