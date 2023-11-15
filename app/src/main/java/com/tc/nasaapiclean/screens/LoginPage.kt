package com.tc.nasaapiclean.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tc.nasaapiclean.R

@Composable
fun LoginPage(){
    Surface (modifier = Modifier.fillMaxSize(), color = Color.White){
        Login()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {
    var text by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }

    Box(
        contentAlignment = Alignment.Center, // Centers the content inside Box
        modifier = Modifier.fillMaxSize() // Box to take up the entire available space
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Centers content horizontally inside Column
            verticalArrangement = Arrangement.Center, // Centers content vertically inside Column
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center) // Ensures the Column itself is centered in the Box
        ) {
            Text(
                text = "Login Page",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.8f),
                value = text,
                onValueChange = { text = it },
                leadingIcon = { Icon(painter = painterResource(id = R.drawable.email), contentDescription = "A photo of mail") },
                label = { Text("Email") }
            )
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.8f),
                value = text2,
                onValueChange = { text2 = it },
                leadingIcon = { Icon(painter = painterResource(id = R.drawable.lock_key), contentDescription = "A key lock") },
                label = { Text("Password") }
            )
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Button(
                onClick = { /* Handle click */ },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(text = "Login")
            }
        }
    }
}

@Preview
@Composable
fun PreviewLoginPage(){

}