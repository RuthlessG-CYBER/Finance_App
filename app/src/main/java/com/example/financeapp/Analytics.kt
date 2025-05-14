package com.example.financeapp


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun AnalyticsUI(
    navController: NavHostController,
    selectedMonth: MonthYear,
    onMonthSelected: (MonthYear) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().systemBarsPadding()){
        Text(
            text = "Analytics",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 25.sp,
            letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "My Spending",
                            fontSize = 15.sp,
                            color = Color.DarkGray,
                            modifier = Modifier.padding(start = 20.dp)
                            )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "$7,200.13",
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 20.dp),
                            fontWeight = FontWeight.Bold
                            )
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.width(20.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowDropUp,
                                contentDescription = null,
                                tint = Color(0xFF4CAF50),
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "12.34%",
                                color = Color(0xFF4CAF50),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "from last week",
                                color = Color.Black,
                                fontSize = 13.sp
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        SimpleBarChart(data = listOf(0.3f, 0.6f, 0.5f, 0.9f, 0.7f, 0.6f, 0.4f))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.fillMaxSize()
            .padding(start = 20.dp, end = 20.dp)){
            Row {
                Column {
                    Text(
                        text = "Expense",
                        fontSize = 15.sp,
                        color = Color.DarkGray
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = selectedMonth.expences,
                        fontSize = 25.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                var expanded by remember { mutableStateOf(false) }

                OutlinedButton(onClick = { expanded = true },
                    modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                    Row {
                        Text(
                            text = "${selectedMonth.month} ${selectedMonth.year}",
                            color = Color.Black,
                            fontSize = 15.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(20.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
                Box {
                    androidx.compose.material3.DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.background(Color.White)
                            .align(Alignment.CenterEnd)
                    ) {
                        monthYearList.forEach { monthYear ->
                            androidx.compose.material3.DropdownMenuItem(
                                text = { Text("${monthYear.month} ${monthYear.year}") },
                                onClick = {
                                    onMonthSelected(monthYear)
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Divider()
            Spacer(modifier = Modifier.height(20.dp))
            selectedMonth.dataList.forEach { item ->
                Row {
                    Icon(Icons.Default.Adjust,
                        contentDescription = null,
                        modifier = Modifier.size(10.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = item.text,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = item.amount,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )

                }
                Spacer(modifier = Modifier.height(20.dp))
            }

        }
    }
}

@Composable
fun SimpleBarChart(
    data: List<Float>, // values between 0f–1f
    labels: List<String> = listOf("S", "M", "T", "W", "T", "F", "S"),
    barColor: Color = Color(0xFF81C784)
) {
    val maxBarHeight = 100.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        data.forEachIndexed { index, value ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .width(12.dp)
                        .height(maxBarHeight * value.coerceIn(0f, 1f))
                        .clip(RoundedCornerShape(4.dp))
                        .background(barColor)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = labels.getOrElse(index) { "" }, fontSize = 10.sp)
            }
        }
    }
}


