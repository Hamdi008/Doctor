package com.hel.doctor.viewModel

import androidx.lifecycle.LiveData
import com.hel.doctor.roomDb.AppDatabase
import com.hel.doctor.roomDb.User

class UserRepository(private val db: AppDatabase) {

    suspend fun insert(user: User) {
        db.userDao.insertUser(user)
    }

    suspend fun getUser(username: String, password: String): User? {
        return db.userDao.getUser(username, password)
    }

    fun getAllUsers(): LiveData<List<User>> {
        return db.userDao.getAllUsers()
    }

}
