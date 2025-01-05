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
    
    /*
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

     */

    // CRUD Operations:
    // 1-Create/Insert Operations:
    fun insertUser(user: User) = viewModelScope.launch {
        userRepository.insertUser(user)
    }
    fun insertUsers(users: List<User>) = viewModelScope.launch {
        userRepository.insertUsers(users)
    }

    fun insertUser(username: String, email: String, password: String) = viewModelScope.launch {
        userRepository.insertUser(username, email, password)
    }

    // 2- Read/Select Operations:
    suspend fun getUser(username: String, password: String): User? {
        return userRepository.getUser(username, password)
    }

    fun getAllUsers(): LiveData<List<User>> {
        return userRepository.getAllUsers()
    }

    suspend fun getUserById(id: Int): User? {
        return userRepository.getUserById(id)
    }

    suspend fun getUserByUsername(username: String): User? {
        return userRepository.getUserByUsername(username)
    }

    suspend fun getUserByEmail(email: String): User? {
        return userRepository.getUserByEmail(email)
    }

    suspend fun getUserByUsernameAndEmail(username: String, email: String): User? {
        return userRepository.getUserByUsernameAndEmail(username, email)
    }

    suspend fun getUsersByUsername(username: String): List<User> {
        return userRepository.getUsersByUsername(username)
    }

    suspend fun getUsersByEmail(email: String): List<User> {
        return userRepository.getUsersByEmail(email)
    }

    suspend fun getUsersByUsernameAndEmail(username: String, email: String): List<User> {
        return userRepository.getUsersByUsernameAndEmail(username, email)
    }

    suspend fun getUsersByUsernameOrEmail(username: String, email: String): List<User> {
        return userRepository.getUsersByUsernameOrEmail(username, email)
    }

    suspend fun getUsersByUsernameAndPassword(username: String, password: String): List<User> {
        return userRepository.getUsersByUsernameAndPassword(username, password)
    }

    suspend fun getUsersByEmailAndPassword(email: String, password: String): List<User> {
        return userRepository.getUsersByEmailAndPassword(email, password)
    }

    suspend fun getUsersByUsernameAndEmailAndPassword(username: String, email: String, password: String): List<User> {
        return userRepository.getUsersByUsernameAndEmailAndPassword(username, email, password)
    }

    suspend fun getUsersByUsernameOrEmailOrPassword(username: String, email: String, password: String): List<User> {
        return userRepository.getUsersByUsernameOrEmailOrPassword(username, email, password)
    }

    suspend fun getUsersByUsernameAndEmailOrPassword(username: String, email: String, password: String): List<User> {
        return userRepository.getUsersByUsernameAndEmailOrPassword(username, email, password)
    }

    // 3- Update Operations:
    fun updateUsername(id: Int, username: String) = viewModelScope.launch {
        userRepository.updateUsername(id, username)
    }

    fun updateEmail(id: Int, email: String) = viewModelScope.launch {
        userRepository.updateEmail(id, email)
    }

    fun updatePassword(id: Int, password: String) = viewModelScope.launch {
        userRepository.updatePassword(id, password)
    }

    fun updateUser(id: Int, username: String, email: String, password: String) = viewModelScope.launch {
        userRepository.updateUser(id, username, email, password)
    }

    fun updateUserDetails(id: Int, username: String, email: String) = viewModelScope.launch {
        userRepository.updateUserDetails(id, username, email)
    }

    // 4- Delete Operations:
    fun deleteAll() = viewModelScope.launch {
        userRepository.deleteAll()
    }

    fun deleteById(id: Int) = viewModelScope.launch {
        userRepository.deleteById(id)
    }

    fun deleteByUsername(username: String) = viewModelScope.launch {
        userRepository.deleteByUsername(username)
    }

    fun deleteByEmail(email: String) = viewModelScope.launch {
        userRepository.deleteByEmail(email)
    }

    fun deleteByUsernameAndEmail(username: String, email: String) = viewModelScope.launch {
        userRepository.deleteByUsernameAndEmail(username, email)
    }

    fun deleteByUsernameOrEmail(username: String, email: String) = viewModelScope.launch {
        userRepository.deleteByUsernameOrEmail(username, email)
    }

    fun deleteByUsernameAndEmailOrPassword(username: String, email: String, password: String) = viewModelScope.launch {
        userRepository.deleteByUsernameAndEmailOrPassword(username, email, password)
    }



}
