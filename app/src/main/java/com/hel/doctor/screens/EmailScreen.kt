package com.hel.doctor.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hel.doctor.ui.theme.DoctorTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EmailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            ApplicationTopBar(
                title = "Dr. Hamdi FEKIH",
                onNavigationClick = { navController.navigate("home")  } // Navigate back to HomeScreen
            )
        },
        content = {
            EmailContent(navController = navController)
        }
    )
}

@Composable
fun EmailContent(navController: NavController, onBackClick: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "We'd love to hear from you!",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Email Input
        var emailState by remember { mutableStateOf("") }
        OutlinedTextField(
            value = emailState,
            onValueChange = { emailState = it },
            label = { Text("Your Email") },
            placeholder = { Text("Enter your email address") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon"
                )
            },
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Message Input
        var messageState by remember { mutableStateOf("") }
        OutlinedTextField(
            value = messageState,
            onValueChange = { messageState = it },
            label = { Text("Your Message") },
            placeholder = { Text("Write your message here") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            shape = RoundedCornerShape(12.dp),
            maxLines = 6
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Send Button
        Button(
            onClick = { /* Handle email sending */ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Send Message", fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmailScreenPreview() {
    DoctorTheme {
        val navController = rememberNavController()
        EmailScreen(navController)
    }
}