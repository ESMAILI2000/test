package com.enet.test.ui.view.contact

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@SuppressLint("SuspiciousIndentation")
@Composable
fun ContactDetailScreen(
    viewModel: ContactViewModel = viewModel()
) {
    // گوش دادن به تغییرات StateFlow در ViewModel
    LaunchedEffect(Unit) {
        viewModel.findcontact()
    }
    val contact = viewModel.selectedContact.value
    // با استفاده از `contact?.let` اطمینان حاصل می‌کنیم که contact خالی نیست
    val uriList = remember(contact) {
        contact?.images?.mapNotNull { imagePath ->
            imagePath.uri.takeIf { it.isNotBlank() }?.let { android.net.Uri.parse(it) }
        } ?: emptyList()
    }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (contact != null){
                Text(text = "Name: ${contact.name}")
                Text(text = "Phone: ${contact.phone_number}")
                Text(text = "Age: ${contact.age}")
                Text(text = "Address: ${contact.address?.city ?: "N/A"}")
            }


            // نمایش تصاویر در LazyRow
            if (uriList.isNotEmpty()) {
                LazyRow {
                    items(items = uriList) { uri: Uri ->
                        Image(
                            painter = rememberAsyncImagePainter(uri),
                            contentDescription = null,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .padding(4.dp)
                        )
                    }
                }
            } else {
                Text(text = "No images available")
            }
        }

}