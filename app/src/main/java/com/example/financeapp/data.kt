package com.example.financeapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class data(
    var image: ImageVector,
    var profileName: String,
    var paymentTime: String,
    var paymentAmount: String,
    var paymentStatus: String
)

val dataList = listOf(
    data(Icons.Default.Person, "Dribble", "Today, 10:30", "-$120", "Transferred"),
    data(Icons.Default.Person, "Maxx", "Yesterday, 11:45", "-$20", "Transferred"),
    data(Icons.Default.Person, "Arijit", "Today, 1:03", "-$10", "Transferred"),
    data(Icons.Default.Person, "Kiran", "Yesterday, 1:50", "-$1200", "Transferred")
)
