package com.hel.doctor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.hel.doctor.navigation.AppNavigation
import com.hel.doctor.roomDb.AppDatabase
import com.hel.doctor.ui.theme.DoctorTheme
import com.hel.doctor.viewModel.UserRepository
import com.hel.doctor.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            name = "users.db"
        ).build()
    }
    val viewModel by viewModels<UserViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return UserViewModel(userRepository = UserRepository(db)) as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DoctorTheme {
                AppNavigation()
            }
        }
    }
}
