package com.enet.test.ui.view.`object`

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enet.test.ui.data.ObjectRepository
import com.enet.test.ui.model.ObjectRequest
import com.enet.test.ui.model.ObjectResponse
import kotlinx.coroutines.launch

class ObjectViewModel : ViewModel() {
    private val repository = ObjectRepository()

//    یک نمونه از مدل پاسخ api
   private var obj by mutableStateOf<ObjectResponse?>(null)


    fun creatObject(objectRequest: ObjectRequest) {
        viewModelScope.launch {
            val result = repository.sendObject(objectRequest)
            obj=result
        }
    }
}