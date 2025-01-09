package com.hel.doctor.roomDb

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(manifest= Config.NONE)
@RunWith(RobolectricTestRunner::class)
class DatabaseUnitTest {

    private lateinit var appDatabase: AppDatabase
    private lateinit var userDao: UserDao

    @Before
    fun setup() {
        // Create an in-memory database for testing
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        userDao = appDatabase.userDao
    }

    @After
    fun terminate() {
        appDatabase.close()
    }

    @Test
    fun insertUserAndGetById() = runBlocking {
        val entity = User(id = 1, username = "test", email = "test", password = "test")
        userDao.insertUser(entity)

        val retrievedEntity = userDao.getUserById(1)
        assertEquals(entity, retrievedEntity)
    }

    @Test
    fun updateUserAndRetrieve() = runBlocking {
        val user = User(id = 1, username = "oldUser", email = "old@example.com", password = "oldpass")
        userDao.insertUser(user)

        userDao.updateUser(1, "newUser", "new@example.com", "newpass")

        val updatedUser = userDao.getUserById(1)
        assertEquals("newUser", updatedUser?.username)
        assertEquals("new@example.com", updatedUser?.email)
        assertEquals("newpass", updatedUser?.password)
    }

    @Test
    fun deleteUserAndVerify() = runBlocking {
        val user = User(id = 1, username = "userToDelete", email = "delete@example.com", password = "deletepass")
        userDao.insertUser(user)

        userDao.deleteById(1)

        val deletedUser = userDao.getUserById(1)
        assertNull(deletedUser)
    }

    @Test
    fun getUserByUsername() = runBlocking {
        val user = User(id = 1, username = "uniqueUser", email = "unique@example.com", password = "uniquepass")
        userDao.insertUser(user)

        val retrievedUser = userDao.getUserByUsername("uniqueUser")
        assertEquals(user, retrievedUser)
    }
}