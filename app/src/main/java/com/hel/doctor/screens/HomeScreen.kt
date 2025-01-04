package com.hel.doctor.screens

import com.hel.doctor.R

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hel.doctor.ui.theme.DoctorTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        contentColor = Color.White,
        containerColor = Color.White,
        topBar = {
            ApplicationTopBar(
                title = "Dr. Bouchra Jerbi Ep Fekih",
                actions = {
                    IconButton(onClick = { navController.navigate("signIn") }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.Login, contentDescription = "SignIn")
                    }
                })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("email")
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
                    .background(Color(0xB3FFFFFF))
                    .padding(vertical = 12.dp, horizontal = 16.dp)

            ) {
                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "Don't have an account?",
                    fontSize = 16.sp,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    onClick = { navController.navigate("signUp") },
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
        ContentBodyWithItems()
    }
}

@Composable
fun ContentBodyWithItems() {
    // Wrap the LazyColumn with the scrollable modifier
    LazyColumn(modifier = Modifier.padding(2.dp)) {
        // Image as the first item
        item {
            Image(
                modifier = Modifier
                    .padding(top = 110.dp)
                    .height(400.dp)
                    .fillMaxWidth()
                    .clip(shape = CircleShape),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.logo_black),
                contentDescription = null
            )
        }

        // Description Text as the second item
        item {
            DescriptionText()
        }
        item {
            DescriptionText()
        }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationTopBar(
    title: String,
    onNavigationClick: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.Blue,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(Color.Cyan),
        navigationIcon = {
            IconButton(onClick = { onNavigationClick?.invoke() }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        },
        actions = actions
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppContentPreview() {
    DoctorTheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}