package com.hel.doctor.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hel.doctor.roomDb.User
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    /*    init {
            val userDao = AppDatabase.getDatabase(application).userDao()
            repository = UserRepository(userDao)
        }
    */
    fun insertUser(user: User) = viewModelScope.launch {
        userRepository.insert(user)
    }

    fun getUser(username: String, password: String): LiveData<User?> {
        val result = MutableLiveData<User?>()
        viewModelScope.launch {
            result.postValue(userRepository.getUser(username, password))
        }
        return result
    }

    fun getAllUsers(): LiveData<List<User>> {
        return userRepository.getAllUsers()
    }
}
