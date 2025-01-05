package com.hel.doctor.viewModel

import androidx.lifecycle.LiveData
import com.hel.doctor.roomDb.AppDatabase
import com.hel.doctor.roomDb.User

class UserRepository(private val db: AppDatabase) {

    // CRUD Operations:
    // 1-Create/Insert Operations:
    suspend fun insertUser(user: User) {
        db.userDao.insertUser(user)
    }

    suspend fun insertUsers(users: List<User>) {
        db.userDao.insertUsers(users)
    }

    suspend fun insertUser(username: String, email: String, password: String) {
        db.userDao.insertUser(username, email, password)
    }

    // 2- Read/Select Operations:
    suspend fun getUser(username: String, password: String): User? {
        return db.userDao.getUser(username, password)
    }

    fun getAllUsers(): LiveData<List<User>> {
        return db.userDao.getAllUsers()
    }

    suspend fun getUserById(id: Int): User? {
        return db.userDao.getUserById(id)
    }

    suspend fun getUserByUsername(username: String): User? {
        return db.userDao.getUserByUsername(username)
    }

    suspend fun getUserByEmail(email: String): User? {
        return db.userDao.getUserByEmail(email)
    }

    suspend fun getUserByUsernameAndEmail(username: String, email: String): User? {
        return db.userDao.getUserByUsernameAndEmail(username, email)
    }

    suspend fun getUsersByUsername(username: String): List<User> {
        return db.userDao.getUsersByUsername(username)
    }

    suspend fun getUsersByEmail(email: String): List<User> {
        return db.userDao.getUsersByEmail(email)
    }

    suspend fun getUsersByUsernameAndEmail(username: String, email: String): List<User> {
        return db.userDao.getUsersByUsernameAndEmail(username, email)
    }

    suspend fun getUsersByUsernameOrEmail(username: String, email: String): List<User> {
        return db.userDao.getUsersByUsernameOrEmail(username, email)
    }

    suspend fun getUsersByUsernameAndPassword(username: String, password: String): List<User> {
        return db.userDao.getUsersByUsernameAndPassword(username, password)
    }

    suspend fun getUsersByEmailAndPassword(email: String, password: String): List<User> {
        return db.userDao.getUsersByEmailAndPassword(email, password)
    }

    suspend fun getUsersByUsernameAndEmailAndPassword(username: String, email: String, password: String): List<User> {
        return db.userDao.getUsersByUsernameAndEmailAndPassword(username, email, password)
    }


    suspend fun getUsersByUsernameOrEmailOrPassword(username: String, email: String, password: String): List<User> {
        return db.userDao.getUsersByUsernameOrEmailOrPassword(username, email, password)
    }

    suspend fun getUsersByUsernameAndEmailOrPassword(username: String, email: String, password: String): List<User> {
        return db.userDao.getUsersByUsernameAndEmailOrPassword(username, email, password)
    }

    // 3- Update Operations:
    suspend fun updateUsername(id: Int, username: String) {
        db.userDao.updateUsername(id, username)
    }

    suspend fun updateEmail(id: Int, email: String) {
        db.userDao.updateEmail(id, email)
    }

    suspend fun updatePassword(id: Int, password: String) {
        db.userDao.updatePassword(id, password)
    }

    suspend fun updateUser(id: Int, username: String, email: String, password: String) {
        db.userDao.updateUser(id, username, email, password)
    }

    suspend fun updateUserDetails(id: Int, username: String, email: String) {
        db.userDao.updateUserDetails(id, username, email)
    }

    // 4- Delete Operations:
    suspend fun deleteAll() {
        db.userDao.deleteAll()
    }

    suspend fun deleteById(id: Int) {
        db.userDao.deleteById(id)
    }

    suspend fun deleteByUsername(username: String) {
        db.userDao.deleteByUsername(username)
    }

    suspend fun deleteByEmail(email: String) {
        db.userDao.deleteByEmail(email)
    }

    suspend fun deleteByUsernameAndEmail(username: String, email: String) {
        db.userDao.deleteByUsernameAndEmail(username, email)
    }

    suspend fun deleteByUsernameOrEmail(username: String, email: String) {
        db.userDao.deleteByUsernameOrEmail(username, email)
    }

    suspend fun deleteByUsernameAndEmailOrPassword(username: String, email: String, password: String) {
        db.userDao.deleteByUsernameAndEmailOrPassword(username, email, password)
    }

}
