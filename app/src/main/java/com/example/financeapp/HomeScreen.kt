package com.example.financeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BackHand
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeUI(){
    Column(modifier = Modifier.fillMaxSize().systemBarsPadding()){
        Spacer(modifier = Modifier.height(10.dp))
        Card(modifier = Modifier.height(80.dp).fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
            ){
            Box(modifier = Modifier.fillMaxSize()){
                Row(modifier = Modifier.fillMaxSize()){
                    Column(modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 20.dp)){
                        Text(
                            text = "Hi, Soumya",
                            fontWeight = FontWeight.Normal,
                            fontSize = 25.sp,
                            modifier = Modifier,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Welcome Back!",
                            fontSize = 15.sp,
                            modifier = Modifier,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "Notification",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.CenterVertically)
                            .padding(end = 20.dp),
                        tint = Color.Black
                    )
                }
            }
        }
        var isVisible by remember { mutableStateOf(true) }

        Card(modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )){
            Column(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)){
                Text(
                    text = "Wallet Balance",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 20.dp),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(
                        text = if(isVisible) "*******" else "$17,290.91",
                        fontSize = 35.sp,
                        modifier = Modifier.padding(start = 20.dp).align(Alignment.CenterVertically),
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    IconButton(
                        onClick = { isVisible = !isVisible },
                        modifier = Modifier.padding(end = 20.dp)
                    ) {
                        Icon(
                            imageVector = if (isVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (isVisible) "Show Balance" else "Hide Balance",
                            modifier = Modifier.size(30.dp),
                            tint = Color.Black
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(modifier = Modifier.fillMaxWidth().height(60.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )){
            Row(modifier = Modifier.fillMaxSize()){
                Text(
                    text = "Cards",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 20.dp).align(Alignment.CenterVertically),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(20.dp))
                Card(modifier = Modifier.size(50.dp).align(Alignment.CenterVertically),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFb8dec7)
                    ),
                    shape = RoundedCornerShape(30.dp)
                    ){
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                        ){
                        Card(modifier = Modifier.size(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF0e4724)
                            ),
                            shape = RoundedCornerShape(30.dp)
                        ){
                            Icon(Icons.Default.Add,
                                contentDescription = "Add",
                                modifier = Modifier
                                    .fillMaxSize(),
                                tint = Color.White
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Card(modifier = Modifier.height(50.dp).width(90.dp).align(Alignment.CenterVertically),
                    shape = RoundedCornerShape(10.dp)
                    ){
                    Box {
                        Image(painter = painterResource(R.drawable.card_background1),
                            contentDescription = "Card Background",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = androidx.compose.ui.layout.ContentScale.Crop
                        )
                        Text(
                            text = "**** 4912",
                            color = Color.White,
                            modifier = Modifier.padding(start = 10.dp).align(Alignment.BottomStart),

                            )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Card(modifier = Modifier.height(50.dp).width(90.dp).align(Alignment.CenterVertically),
                    shape = RoundedCornerShape(10.dp)){
                    Box {
                        Image(painter = painterResource(R.drawable.card_background2),
                            contentDescription = "Card Background",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = androidx.compose.ui.layout.ContentScale.Crop
                        )
                        Text(
                            text = "**** 5238",
                            color = Color.White,
                            modifier = Modifier.padding(start = 10.dp).align(Alignment.BottomStart),

                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
            ){
            Row(modifier = Modifier.fillMaxWidth()){
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = {},
                    modifier = Modifier.align(Alignment.CenterVertically),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF104826)
                    )
                    ) {
                    Icon(Icons.Default.Send,
                        contentDescription = "Send Icon",
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Send")
                }
                Spacer(modifier = Modifier.width(5.dp))
                TextButton(onClick = {},
                    modifier = Modifier.align(Alignment.CenterVertically),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF95e686)
                    )) {
                    Icon(
                        Icons.Default.BackHand,
                        contentDescription = "Request Icon",
                        tint = Color(0xFF075E20)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Request",
                        color = Color(0xFF075E20)
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Card(modifier = Modifier.size(40.dp).align(Alignment.CenterVertically),
                    shape = RoundedCornerShape(25.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFc8d8ce))
                    ){
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                        ){
                        Icon(
                            Icons.Default.Dashboard,
                            contentDescription = "Dashboard Icon",
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Card(modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFAFCFA)
            ),
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
            ){
            Column(modifier = Modifier.fillMaxSize()){
                Row(modifier = Modifier.fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)){
                    Text(text = "Recent Activity",
                        fontSize = 15.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontWeight = FontWeight.Bold
                        )
                    Spacer(modifier = Modifier.weight(1f))
                    Row{
                        Text(text = "See Details",
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color(0xFF47815a),
                            fontWeight = FontWeight.Bold
                            )
                        Icon(Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                                .align(Alignment.CenterVertically),
                            tint = Color(0xFF47815a)
                        )

                    }
                }
                Spacer(modifier = Modifier.height(15.dp))

                Column(modifier = Modifier){
                    dataList.take(6).forEach { item ->
                        Card(modifier = Modifier.fillMaxWidth()
                            .height(70.dp)
                            .padding(start = 20.dp, end = 20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Transparent
                            )
                            ){
                            Row(modifier = Modifier.fillMaxSize()
                                .padding(start = 10.dp, end = 10.dp)
                            ){
                                Card(modifier = Modifier.size(60.dp).align(Alignment.CenterVertically),
                                    shape = RoundedCornerShape(30.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.LightGray
                                    )
                                ){
                                    Image(imageVector = item.image,
                                        contentDescription = "Profile Image",
                                        contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                                Spacer(modifier = Modifier.width(15.dp))
                                Card(modifier = Modifier.fillMaxSize()
                                    .padding(top = 15.dp, bottom = 15.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.Transparent
                                    )
                                    ){
                                    Box(modifier = Modifier.fillMaxSize()) {
                                        Text(
                                            text = item.profileName,
                                            modifier = Modifier
                                                .align(Alignment.TopStart)
                                                .padding(start = 5.dp, end = 5.dp),
                                            fontWeight = FontWeight.Bold,
                                            letterSpacing = 1.sp
                                        )
                                        Text(
                                            text = item.paymentAmount,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(start = 5.dp, end = 5.dp),
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = item.paymentTime,
                                            modifier = Modifier
                                                .align(Alignment.BottomStart)
                                                .padding(start = 5.dp, end = 5.dp)
                                        )
                                        Text(
                                            text = item.paymentStatus,
                                            modifier = Modifier
                                                .align(Alignment.BottomEnd)
                                                .padding(start = 5.dp, end = 5.dp)
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }
        }
    }
}
