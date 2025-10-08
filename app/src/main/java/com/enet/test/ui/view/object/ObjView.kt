package com.enet.test.ui.view.`object`

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.enet.test.ui.model.ObjectData
import com.enet.test.ui.model.ObjectRequest
import com.enet.test.ui.view.hapoo.Hapooviewmodel

@Composable
fun ObjectScreen(viewModel: ObjectViewModel = viewModel()) {
    var field1 by remember { mutableStateOf("") }
    var field2 by remember { mutableStateOf("") }
    var field3 by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "ایجاد شیء جدید", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = field1,
            onValueChange = { field1 = it },
            label = { Text("فیلد اول") }
        )

        OutlinedTextField(
            value = field2,
            onValueChange = { field2 = it },
            label = { Text("فیلد دوم") }
        )

        OutlinedTextField(
            value = field3,
            onValueChange = { field3 = it },
            label = { Text("فیلد سوم") }
        )

        Button(onClick = {
            val request = ObjectRequest(
                name = "field1",
                data = ObjectData(2009,60.4,"field2","field3")
            )
            viewModel.creatObject(request)
        }) {
            Text("ارسال")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("نتیجه:", style = MaterialTheme.typography.titleMedium)
//        viewModel.obj?.let {
//            Text("مقدار دریافتی: ${it.createdAt}")
//        }

    }
}

