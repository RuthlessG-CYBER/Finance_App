package com.example.financeapp

//data class CardInfo(val number: String, val backgroundRes: Int)
//
//val cards = remember { mutableStateListOf<CardInfo>() }
//var showDialog by remember { mutableStateOf(false) }
//var cardNumber by remember { mutableStateOf("") }
//
//if (showDialog) {
//    AlertDialog(
//        onDismissRequest = { showDialog = false },
//        title = { Text("Add Card") },
//        text = {
//            Column {
//                OutlinedTextField(
//                    value = cardNumber,
//                    onValueChange = { cardNumber = it },
//                    label = { Text("Card Number") }
//                )
//            }
//        },
//        confirmButton = {
//            TextButton(onClick = {
//                if (cardNumber.isNotBlank()) {
//                    cards.add(CardInfo("**** ${cardNumber.takeLast(4)}", R.drawable.card_background1))
//                    cardNumber = ""
//                    showDialog = false
//                }
//            }) {
//                Text("Add")
//            }
//        },
//        dismissButton = {
//            TextButton(onClick = {
//                showDialog = false
//                cardNumber = ""
//            }) {
//                Text("Cancel")
//            }
//        }
//    )
//}
//
//Row {
//    Text("Cards", modifier = Modifier.align(Alignment.CenterVertically))
//
//    Spacer(modifier = Modifier.width(10.dp))
//
//    // Add Button Card
//    Card(
//        modifier = Modifier
//            .size(50.dp)
//            .clickable { showDialog = true },
//        shape = RoundedCornerShape(30.dp),
//        colors = CardDefaults.cardColors(containerColor = Color(0xFFb8dec7))
//    ) {
//        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
//            Icon(
//                imageVector = Icons.Default.Add,
//                contentDescription = "Add Card",
//                tint = Color.White
//            )
//        }
//    }
//
//    Spacer(modifier = Modifier.width(10.dp))
//
//    // Dynamically Render Added Cards
//    cards.forEach { card ->
//        Card(
//            modifier = Modifier
//                .height(50.dp)
//                .width(90.dp)
//                .padding(end = 8.dp),
//            shape = RoundedCornerShape(10.dp)
//        ) {
//            Box {
//                Image(
//                    painter = painterResource(card.backgroundRes),
//                    contentDescription = "Card Background",
//                    modifier = Modifier.fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                )
//                Text(
//                    text = card.number,
//                    color = Color.White,
//                    modifier = Modifier
//                        .align(Alignment.BottomStart)
//                        .padding(start = 10.dp)
//                )
//            }
//        }
//    }
//}
