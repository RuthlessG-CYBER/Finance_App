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
    data(Icons.Default.Person, "Maxx", "Today, 11:45", "-$20", "Transferred"),
    data(Icons.Default.Person, "Arijit", "Today, 1:03", "-$10", "Transferred"),
    data(Icons.Default.Person, "Kiran", "Today, 1:50", "-$1200", "Transferred"),
    data(Icons.Default.Person, "Aaiee", "Today, 10:30", "-$120", "Transferred"),
    data(Icons.Default.Person, "Maxx", "Today, 11:45", "-$20", "Transferred"),
    data(Icons.Default.Person, "Marchent", "Yesterday, 1:03", "-$10", "Transferred"),
    data(Icons.Default.Person, "Kiran", "Yesterday, 1:50", "-$1200", "Transferred"),
    data(Icons.Default.Person, "Dribble", "Yesterday, 10:30", "-$120", "Transferred"),
    data(Icons.Default.Person, "Maxx", "Yesterday, 11:45", "-$20", "Transferred"),
    data(Icons.Default.Person, "Abhijit", "Yesterday, 1:03", "-$10", "Transferred"),
    data(Icons.Default.Person, "Suman", "Yesterday, 1:50", "-$1200", "Transferred")
)

data class datas(
    var text : String,
    var amount : String
)

val dataList2 = listOf(
    datas("Healthcare", "+$200"),
    datas("Food", "-$1200"),
    datas("Utilities", "+$1200"),
    datas("Transportation", "-$1200"),
    datas("Suplies", "+$1200"),

)
val dataList3 = listOf(
    datas("Utilities", "-$200"),
    datas("Healthcare", "-$150"),
    datas("Food", "+$1200"),
    datas("Suplies", "-$100"),
    datas("Transportation", "+$500")
)
val dataList4 = listOf(
    datas("Food", "-$100"),
    datas("Healthcare", "+$700"),
    datas("Transportation", "-$100"),
    datas("Utilities", "+$120"),
    datas("Suplies", "+$200"),

)

data class MonthYear(
    val month: String,
    val year: Int,
    val dataList: List<datas>,
    val expences: String
)

val monthYearList = listOf(
    MonthYear("January", 2025, dataList2, "-$2000"),
    MonthYear("February", 2025, dataList3, "-$5000"),
    MonthYear("March", 2025, dataList4, "+$8200"),
    MonthYear("April", 2025, dataList3, "+$9000"),
    MonthYear("May", 2025, dataList4, "-$1400"),
    MonthYear("June", 2025, dataList2, "+$7000"),
    MonthYear("July", 2025, dataList3, "-$2000"),
    MonthYear("August", 2025, dataList4, "-$1100"),
    MonthYear("September", 2025, dataList2, "+$1200"),
    MonthYear("October", 2025, dataList4, "-$3000"),
    MonthYear("November", 2025, dataList3, "+$2700"),
    MonthYear("December", 2025, dataList2, "-$1700")
)

data class CardInfo(
    val name: String,
    val number: String,
    val expiry: String,
    val cvv: String
)

val cards = listOf(
    CardInfo("Alice", "1234567890123456", "12/24", "123"),
    CardInfo("Bob", "9876543210987654", "10/23", "321")
)
