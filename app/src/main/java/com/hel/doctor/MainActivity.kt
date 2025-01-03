package com.hel.doctor

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hel.doctor.ui.theme.DoctorTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DoctorTheme {
                HomeScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val snackbarHostState = SnackbarHostState()
    val coroutineScope = rememberCoroutineScope()
    val items = listOf("Home", "Profile", "Settings")

    Scaffold(
        contentColor = Color.White,
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Dr. Bouchra Jerbi Ep Fekih",
                        color = Color.Blue,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic,

                        modifier = Modifier.padding(start = 20.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Cyan),
                navigationIcon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                actions = {
                    Icon(imageVector = Icons.AutoMirrored.Filled.Login, contentDescription = "SignIn")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("FAB Clicked!")
                    }
                }
            ) {
                Icon(Icons.Default.Email, contentDescription = "Add")
            }
        },
        bottomBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
            ) {
                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "Don't have an account?",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    onClick = { /* Handle Sign Up Action */ },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Sign Up",
                        tint = Color(0xFF1E88E5),
                    )
                    Text(
                        text = "Sign Up",
                        fontSize = 16.sp,
                        color = Color(0xFF1E88E5),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    ) { paddingValues ->
        // Main content area
        ContentBodyWithItems(
            modifier = Modifier.padding(paddingValues),
            items = items
        )
    }
}

@Composable
fun ContentBodyWithItems(modifier: Modifier = Modifier, items: List<String>) {
    Column(modifier = modifier.padding(2.dp)) {
        Image(
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
                .clip(shape = CircleShape),
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
            painter = painterResource(id = R.drawable.logo_black),
            contentDescription = null
        )
        DescriptionText()
    }
}

@Composable
fun DescriptionText() {
    Text(
        text = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Atque quo dolor officiis ea quam veritatis, tempore ipsum et fugit saepe laboriosam. Natus itaque saepe laudantium et quibusdam odit voluptate velit." +
                "Lorem ipsum dolor sit amet consectetur adipisicing elit. Atque quo dolor officiis ea quam veritatis, tempore ipsum et fugit saepe laboriosam. Natus itaque saepe laudantium et quibusdam odit voluptate velit.",
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        color = Color.Gray,
        textAlign = TextAlign.Center
    )
}


@Preview(showBackground = true)
@Composable
fun AppContentPreview() {
    DoctorTheme {
        HomeScreen()
    }
}