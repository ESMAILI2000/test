package com.enet.test.ui.view.contact

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items // دستی اضافه کنید
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.enet.test.ui.model.Address

@Composable
fun AddContactsScreen(
    viewModel: ContactViewModel = viewModel()
) {
    var namee by remember { mutableStateOf("") }
    var phonee by remember { mutableStateOf("") }
    var agee by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    val address = Address()
    var selectedImages by remember { mutableStateOf<List<Uri>>(emptyList()) }


    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetMultipleContents()
    ) { uris: List<Uri> ->
        selectedImages = uris
    }

    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        TextField(
            value = namee, onValueChange = {namee=it},
            label = { Text(text = "Name")}
        )

        HorizontalDivider()

        TextField(
            value = phonee, onValueChange = {phonee=it},
            label = { Text(text = "Phone")}
        )

        HorizontalDivider()

        TextField(
            value = agee, onValueChange = {agee=it},
            label = { Text(text = "Age")}
        )

        HorizontalDivider()

        TextField(
            value = state, onValueChange = {state=it},
            label = { Text(text = "State")}
        )

        HorizontalDivider()

        TextField(
            value = city, onValueChange = {city=it},
            label = { Text(text = "City")}
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { imagePickerLauncher.launch("image/*") }) {
            Text("انتخاب تصاویر")
        }

        LazyRow {
            items(items = selectedImages) { uri: Uri ->
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

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {

            // تبدیل Uri به String و ارسال به ViewModel
            val imagePaths = selectedImages.map { it.toString() }
            address.apply {
                this.state=state
                this.city=city
            }
            viewModel.addContact(name=namee, age = agee.toInt(), phone = phonee, address = address, imagePaths = imagePaths)
            // تبدیل Uri به String و ارسال به ViewModel
            namee=""
            agee=""
            phonee=""
            state=""
            city=""
        }) {

        }
    }

}