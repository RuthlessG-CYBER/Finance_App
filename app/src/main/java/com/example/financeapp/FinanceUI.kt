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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun FinanceUI(navController: NavHostController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF8acb50)))
    {
        Card(modifier = Modifier
            .padding(start = 1.dp, top = 50.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ))
        {
            Card(modifier = Modifier.size(100.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ))
            {
                Image(
                    painter = painterResource(R.drawable.financelogo),
                    contentDescription = "Finance Logo",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.tint(Color(0xFF2f5909))
                )
            }
        }
        Card(modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(bottom = 50.dp, start = 20.dp, end = 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        )
        {
            Text(
                text = "Track Your \nSpending \nEffortlessly",
                modifier = Modifier.padding(start = 1.dp, top = 2.dp),
                color = Color(0xFF244606),
                fontSize = 45.sp
            )

            Text(
                text = "Manage your finances easily using our intuitive and user friendly interface and set financial goals and monitor your progress.",
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 5.dp),
                color = Color(0xFF244606),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(60.dp))

            TextButton(onClick = { navController.navigate("SignupUI") },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(50.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF224007)
                )
            )
            {
                Text(
                    text = "Get Started",
                    color = Color(0xFF92c764),
                    fontSize = 15.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            )
            {
                Row(modifier = Modifier
                    .fillMaxSize())
                {
                    Spacer(modifier = Modifier.weight(1f))

                    Card(modifier = Modifier
                        .padding(start = 5.dp, end = 1.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        )
                    )
                    {
                        Text(
                            text = "Already have an account?",
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(start = 1.dp, end = 1.dp)
                        )
                    }

                    Card(onClick = {navController.navigate("LoginUI")},
                        modifier = Modifier
                            .height(18.dp).width(40.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        )
                    )
                    {
                        Text(
                            text = "Login",
                            color = Color(0xFF264908),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun LoginUI(navController: NavHostController){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF8acb50)))
    {

        Box(modifier = Modifier
            .align(Alignment.TopStart)
            .padding(start = 25.dp, top = 70.dp)){
            Column {
                Text("Welcome",
                    fontSize = 40.sp,
                    color = Color(0xFF244606),
                    fontWeight = FontWeight.Bold
                )
                Text("Back!",
                    fontSize = 40.sp,
                    color = Color(0xFF244606),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Column(modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center ){

            var email by remember { mutableStateOf("") }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Email") },
                modifier = Modifier.padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 10.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email Icon"
                    )
                }
            )

            Spacer(modifier = Modifier.height(5.dp))

            var password by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Password") },
                modifier = Modifier.padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(bottomEnd = 10.dp),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Locked Icon"
                    )
                },
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextButton(onClick = {
                if (email == "somu@gmail.com" && password == "1234"){
                    navController.navigate("Main")
                }
            },
                modifier = Modifier.padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF224007)
                )
                ){
                Text(
                    text = "LOG IN"
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier)
            {
                Spacer(modifier = Modifier.weight(1f))

                Card(modifier = Modifier
                    .padding(start = 5.dp, end = 1.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ))
                {
                    Text(
                        text = "Already have an account?",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(start = 1.dp, end = 1.dp)
                    )
                }

                Card(onClick = {navController.navigate("SignupUI")},
                    modifier = Modifier
                        .height(18.dp).width(45.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ))
                {
                    Text(
                        text = "signup",
                        color = Color(0xFF264908),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.padding(start = 1.dp).align(Alignment.CenterHorizontally)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun SignupUI(navController: NavHostController){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF8acb50)))
    {

        Box(modifier = Modifier
            .align(Alignment.TopStart)
            .padding(start = 25.dp, top = 70.dp)){
            Column {
                Text("Create",
                    fontSize = 40.sp,
                    color = Color(0xFF244606),
                    fontWeight = FontWeight.Bold
                )
                Text("an account!",
                    fontSize = 40.sp,
                    color = Color(0xFF244606),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Column(modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            var email by remember { mutableStateOf("") }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Email") },
                modifier = Modifier.padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 10.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email Icon"
                    )
                }
            )

            Spacer(modifier = Modifier.height(5.dp))

            var password by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Password") },
                modifier = Modifier.padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Lock Icon"
                    )
                },
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(5.dp))

            var confirmpassword by remember { mutableStateOf("") }

            OutlinedTextField(
                value = confirmpassword,
                onValueChange = { confirmpassword = it },
                placeholder = { Text("Confirm Password") },
                modifier = Modifier.padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(bottomEnd = 10.dp),
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextButton(onClick = { /*TODO*/ },
                modifier = Modifier.padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF224007)
                )
            ){
                Text(
                    text = "SIGN UP"
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier)
            {
                Spacer(modifier = Modifier.weight(1f))

                Card(modifier = Modifier
                    .padding(start = 5.dp, end = 1.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ))
                {
                    Text(
                        text = "Don't have an account!",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(start = 1.dp, end = 1.dp)
                    )
                }

                Card(onClick = {navController.navigate("LoginUI")},
                    modifier = Modifier
                        .height(18.dp).width(40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ))
                {
                    Text(
                        text = "login",
                        color = Color(0xFF264908),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.padding(start = 1.dp, end = 1.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,startDestination = "FinanceUI") {
        composable("SignupUI") {
            SignupUI(navController)
        }
        composable("LoginUI") {
            LoginUI(navController)
        }
        composable("FinanceUI") {
            FinanceUI(navController)
        }
        composable("Main") {
            MainScreen(navController)
        }
    }
}
