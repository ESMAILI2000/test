package com.enet.test.ui.view.hapoo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enet.test.ui.data.Hapoorepository
import com.enet.test.ui.model.Hapoo
import kotlinx.coroutines.launch

class Hapooviewmodel : ViewModel() {
    private val repository = Hapoorepository()

    var Hapoo = mutableStateOf(Hapoo("", ""))
        private set

    init {
        fetchHapoo()
    }

     fun fetchHapoo() {
        viewModelScope.launch {
//            val result = repository.fetchHapoo()
//            Hapoo.value=result
        }
    }
}