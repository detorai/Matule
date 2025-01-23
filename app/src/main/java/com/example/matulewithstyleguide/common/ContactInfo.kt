package com.example.matulewithstyleguide.common

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.Hint
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun ContactInfo(
    modifier: Modifier,
    emailInfo: String,
    onEmail: ()-> Unit,
    phoneInfo: String,
    onPhone: ()-> Unit,
    address: String,
    onAddress: ()-> Unit,
    onCard: ()-> Unit,
    cardInfo: String
){
    Box(
        modifier = modifier.fillMaxWidth().height(425.dp).background(color = Block, shape = RoundedCornerShape(16.dp))
    ){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 20.dp , end = 20.dp)
        ) {
            Text(
                "Контактная информация",
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                lineHeight = 20.sp,
            )
            ChangeInfo(
                modifier = Modifier.padding(top = 16.dp),
                image = R.drawable.email,
                info = emailInfo,
                label = "Email",
                onEdit = onEmail,
                ifEmpty = "*******@****.***",
                edit = R.drawable.edit,
                state = true
            )
            ChangeInfo(
                modifier = Modifier.padding(top = 16.dp),
                image = R.drawable.phone,
                info = phoneInfo,
                label = "Телефон",
                onEdit = onPhone,
                ifEmpty = "**-***-***-****",
                edit = R.drawable.edit,
                state = true
            )
            Box(
                modifier = modifier.padding(top = 12.dp).fillMaxWidth().height(48.dp)
            ){
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.align(Alignment.CenterStart).height(48.dp)
                ) {
                    Text(
                        "Адрес",
                        fontSize = 14.sp,
                        fontFamily = peninimFont,
                        fontWeight = FontWeight.W500,
                        lineHeight = 20.sp,
                        color = TextColor
                    )
                    Text(
                        text = address,
                        fontSize = 14.sp,
                        fontFamily = peninimFont,
                        fontWeight = FontWeight.W500,
                        lineHeight = 20.sp,
                        color = Hint
                    )

                }
                Box(
                    modifier = Modifier.align(Alignment.BottomEnd).size(20.dp).clickable {
                        onAddress()
                    },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            if (address.isEmpty()) R.drawable.arrow_down else R.drawable.edit),
                        contentDescription = "",
                        tint = Color.Unspecified
                    )
                }
            }
            Text(
                "Способ оплаты",
                fontSize = 14.sp,
                fontFamily = peninimFont,
                fontWeight = FontWeight.W500,
                lineHeight = 20.sp,
                color = TextColor
            )
            ChangeInfo(
                modifier = Modifier.padding(top = 12.dp),
                image = R.drawable.card,
                info = "Добавить",
                label = "**** **** $cardInfo",
                onEdit = onCard,
                ifEmpty = "**** ****",
                edit = R.drawable.arrow_down,
                state = false
            )
        }
    }
}