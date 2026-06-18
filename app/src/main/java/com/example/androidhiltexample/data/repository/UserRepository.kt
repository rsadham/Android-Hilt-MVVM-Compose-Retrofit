package com.example.androidhiltexample.data.repository

import com.example.androidhiltexample.data.model.User
import com.example.androidhiltexample.data.remote.UserApi
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserApi
) {

    suspend fun getUsers(): List<User> {
        return api.getUsers()
    }
}