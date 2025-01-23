package com.example.matulewithstyleguide.ui.sprint_4.checkout

import android.telephony.UiccCardInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.matulewithstyleguide.R
import com.example.matulewithstyleguide.common.ButtonWithText
import com.example.matulewithstyleguide.common.ContactInfo
import com.example.matulewithstyleguide.common.CostBox
import com.example.matulewithstyleguide.common.CostRow
import com.example.matulewithstyleguide.data.model.Font.peninimFont
import com.example.matulewithstyleguide.ui.theme.Accent
import com.example.matulewithstyleguide.ui.theme.Background
import com.example.matulewithstyleguide.ui.theme.Block
import com.example.matulewithstyleguide.ui.theme.Hint
import com.example.matulewithstyleguide.ui.theme.TextColor

@Composable
fun Checkout(
    onClickBack:() -> Unit,
    emailInfo: String,
    onEmail: ()-> Unit,
    phoneInfo: String,
    onPhone: ()-> Unit,
    address: String,
    onAddress: ()-> Unit,
    sum: Double,
    deliver: Double,
    fullSum: Double,
    onButtonClick: ()-> Unit,
    showDialog: Boolean,
    onPopup: ()-> Unit,
    onBackShop: ()-> Unit,
    cardInfo: String,
    onCard: ()-> Unit
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
                "Корзина",
                fontFamily = peninimFont,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.W400,
                color = TextColor,
            )
        }
        ContactInfo(
            modifier = Modifier.padding(top = 46.dp),
            emailInfo = emailInfo,
            onEmail = onEmail,
            phoneInfo = phoneInfo,
            onPhone = onPhone,
            address = address,
            onAddress = onAddress,
            cardInfo = cardInfo,
            onCard = onCard
        )
        CostBox(
            sum = sum,
            fullSum = fullSum,
            deliver = deliver,
            modifier = Modifier,
            onButtonClick = onBackShop,
            buttonText = "Подтвердить",
            color = Background
        )
        if (showDialog) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x1B1A2530))
                    .clickable { onPopup() }
            )

            Dialog(
                onDismissRequest = { onPopup() }
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .background(color = Block, shape = RoundedCornerShape(20.dp)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(top = 40.dp)
                            .size(134.dp)
                            .background(color = Color(0xFFDFEFFF), shape = RoundedCornerShape(200.dp))
                    ) {
                        Image(
                            bitmap = ImageBitmap.imageResource(R.drawable.succ),
                            contentDescription = "",
                            modifier = Modifier.size(86.dp)
                        )
                    }

                    Text(
                        "Вы успешно\nоформили\nзаказ",
                        fontWeight = FontWeight.W400,
                        fontFamily = peninimFont,
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        color = TextColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 24.dp),
                        maxLines = 3
                    )
                    ButtonWithText(
                        modifier = Modifier.padding(horizontal = 49.dp, vertical = 30.dp),
                        mainColor = Accent,
                        secondaryColor = Block,
                        onButtonClick = onBackShop,
                        buttonText = "Вернуться к покупкам"
                    )
                }
            }
        }
    }
}