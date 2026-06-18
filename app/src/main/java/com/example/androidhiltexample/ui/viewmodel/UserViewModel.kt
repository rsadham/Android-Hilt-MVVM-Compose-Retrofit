package com.example.androidhiltexample.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhiltexample.data.model.User
import com.example.androidhiltexample.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _users =
        MutableStateFlow<List<User>>(emptyList())

    val users = _users.asStateFlow()

    init {
        loadUsers()
    }

    private fun loadUsers() {

        viewModelScope.launch {

            _users.value =
                repository.getUsers()
        }
    }
}