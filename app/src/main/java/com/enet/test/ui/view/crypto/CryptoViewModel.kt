package com.enet.test.ui.view.crypto

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enet.test.ui.data.CryptoRepository
import com.enet.test.ui.model.CryptoRespons
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {
    private val repository = CryptoRepository()

    var currency by mutableStateOf<CryptoRespons?>(null)

    init {
        fetchCurrency()
    }

    private fun fetchCurrency() {
        viewModelScope.launch {
            val result = repository.getRate("EUR/USD","ee7c1dd21fed4014b5464b0a49bbda9f")
            currency = result
        }
    }
}