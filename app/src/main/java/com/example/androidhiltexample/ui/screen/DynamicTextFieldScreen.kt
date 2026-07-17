package com.example.androidhiltexample.ui.screen

import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.imePadding

@Composable
fun DynamicTextFieldScreen() {

    val textFields = remember { mutableStateListOf("") }

    var submittedList by remember {
        mutableStateOf<List<String>>(emptyList())
    }

    Scaffold { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .navigationBarsPadding()
                .imePadding()
                .padding(16.dp)

        ) {

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {

                itemsIndexed(textFields) { index, text ->
                    OutlinedTextField(
                        value = text,
                        onValueChange = { newText ->
                            textFields[index] = newText
                        },
                        label = { Text("Text Field ${index + 1}") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Button(
                    onClick = {
                        textFields.add("")
                    }
                ) {
                    Text("Add Text Field")
                }

                Button(
                    onClick = {
                        submittedList = textFields.toList()
                    }
                ) {
                    Text("Submit")
                }

            }


            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(modifier = Modifier.border(1.dp, MaterialTheme.colorScheme.primary)) {
                items(submittedList) { text ->
                    Text(text)
                }
            }

        }

    }
}