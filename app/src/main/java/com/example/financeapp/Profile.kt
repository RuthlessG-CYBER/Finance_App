package com.example.financeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 25.dp, end = 25.dp)
            .systemBarsPadding()
    ) {
        // Profile Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.financelogo),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text("Soumya Panda", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("somu@gmail.com", fontSize = 14.sp, color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // Balance Section
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(5.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Current Balance", color = Color.Gray)
                Spacer(modifier = Modifier.height(5.dp))
                Text("$5,450.75", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        // Quick Actions
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {}, modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFf94f26)
                )) {
                Text("Add Money")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {}, modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF224007)
                )
                ) {
                Text("Withdraw")
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // Recent Transactions
        Text("Recent Transactions", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn {
            items(5) { index ->
                TransactionItem(
                    title = "Payment #${index + 1}",
                    amount = "-$${(10..100).random()}.00",
                    time = "Today, 10:${index}0 AM"
                )
            }
        }
    }
}

@Composable
fun TransactionItem(title: String, amount: String, time: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(title, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(5.dp))
            Text(time, fontSize = 12.sp, color = Color.Gray)
        }
        Text(amount, color = Color(0xFF70b065), fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterVertically)
            )
    }
}
