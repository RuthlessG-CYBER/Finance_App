package com.example.financeapp


import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset

@Composable
fun QRScannerScreen() {
    val infiniteTransition = rememberInfiniteTransition()
    val animatedY by infiniteTransition.animateFloat(
        initialValue = 10f,
        targetValue = 650f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Card(
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.Center)
                .border(3.dp, Color.Green, RoundedCornerShape(10.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawLine(
                    color = Color.White,
                    start = Offset(0f, animatedY),
                    end = Offset(size.width, animatedY),
                    strokeWidth = 4f
                )
            }
        }

        Text(
            text = "Scan the QR & Pay using UPI",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp)
        )
    }
}