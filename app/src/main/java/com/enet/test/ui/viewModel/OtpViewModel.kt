package com.enet.sinar.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enet.sinar.ui.data.OtpRepository
import com.enet.sinar.ui.model.OtpDto
import com.enet.sinar.ui.model.VerifyOtpDto
import com.enet.sinar.ui.utility.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OtpViewModel(
    private val repository: OtpRepository = OtpRepository()
) : ViewModel()
{


    var otpCode = mutableStateOf("")
    var phoneNumber = mutableStateOf("")

    private val _otpState = MutableStateFlow<UiState<String>>(UiState.Idle)
    val otpState: StateFlow<UiState<String>> = _otpState.asStateFlow()

    fun sendCod() {
        viewModelScope.launch {
            val otpDto = OtpDto(phoneNumber.value)
            val result = repository.sendOtpCod(otpDto)

            _otpState.value = result.fold(
                onSuccess = { otp ->
                    UiState.Success(otp)
                },
                onFailure = { throwable ->
                    UiState.Error(throwable.message ?: "خطا در دریافت اطلاعات")
                }
            )
        }
    }

    private val _verifyOtpState = MutableStateFlow<UiState<String>>(UiState.Idle)
    val verifyOtpState: StateFlow<UiState<String>> = _verifyOtpState.asStateFlow()

    fun verifyCod() {
        viewModelScope.launch {
            val verifyOtp = VerifyOtpDto(otpCode.value,phoneNumber.value)
            val result = repository.verify(verifyOtp)

            _verifyOtpState.value = result.fold(
                onSuccess = { otp ->
                    UiState.Success(otp)
                },
                onFailure = { throwable ->
                    UiState.Error(throwable.message ?: "خطا در دریافت اطلاعات")
                }
            )
        }
    }
}
