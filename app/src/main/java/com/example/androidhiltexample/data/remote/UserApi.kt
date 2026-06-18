package com.example.androidhiltexample.data.remote

import com.example.androidhiltexample.data.model.User

import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUsers(): List<User>
}