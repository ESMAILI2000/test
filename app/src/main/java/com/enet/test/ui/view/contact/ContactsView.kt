package com.enet.test.ui.view.contact

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items

@Composable
fun ContactsScreen(
    onNavigateToAddContact: () -> Unit = {},
    onNavigateToDetails: () -> Unit = {},
    viewModel: ContactViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.allContacts()
    }

    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = {
                name = it
                viewModel.searchContacts(name)
            },
            label = { Text("جستجوی مخاطب") }
        )

        Button(onClick = { onNavigateToAddContact() }) {
            Text(text = "مخاطب جدید")
        }

        LazyColumn {
            items(viewModel.contacts.size) { contact ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
//                            viewModel.findcontact(viewModel.contacts[contact].phone_number+"")
                            viewModel._id.value = "0987654321"
                            onNavigateToDetails()
                        }
                        .padding(8.dp)
                ) {
                    Column {
                        Text(text = "نام: ${viewModel.contacts[contact].name}")
                        Text(text = "شماره: ${viewModel.contacts[contact].phone_number}")
                    }
                }
            }
        }
    }
}


