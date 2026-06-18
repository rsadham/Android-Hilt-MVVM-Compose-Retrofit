# Android Hilt MVVM Compose Retrofit Example

## Overview

This project demonstrates modern Android development using:

* Jetpack Compose
* MVVM Architecture
* Hilt Dependency Injection
* Retrofit
* StateFlow
* Kotlin Coroutines

## API Used

https://jsonplaceholder.typicode.com/users

## Architecture

Compose UI
↓
ViewModel
↓
Repository
↓
Retrofit API
↓
Network

## Dependency Injection

This project shows how Hilt automatically creates and injects dependencies such as:

* Retrofit
* UserApi
* Repository
* ViewModel

## Folder Structure

data
├── model
├── remote
└── repository

di

ui
├── screen
└── viewmodel

## Key Concepts

### Without Dependency Injection

```kotlin
val retrofit = Retrofit.Builder().build()
val api = retrofit.create(UserApi::class.java)
val repository = UserRepository(api)
val viewModel = UserViewModel(repository)
```

### With Hilt

```kotlin
@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
)
```

## Output

Displays users fetched from a REST API in a Jetpack Compose LazyColumn.

## Author

Sadham Hussain
