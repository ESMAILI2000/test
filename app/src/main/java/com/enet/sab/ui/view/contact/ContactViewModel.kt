package com.enet.sab.ui.view.contact

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enet.sab.ui.model.Contact
import com.enet.sab.ui.model.findContactAll
import com.enet.sab.ui.model.findProfile
import com.enet.sab.ui.model.insertContact
import io.realm.kotlin.Realm
import kotlinx.coroutines.launch

class ContactViewModel : ViewModel() {

    // فیلدهای فرم
    var Name by mutableStateOf("")
    var PhoneNumber by mutableStateOf("")
    var NationalId by mutableStateOf("")
    var Title by mutableStateOf("")
    var Location by mutableStateOf("")
    var Description by mutableStateOf("")

    // وضعیت ثبت
    var isSaved by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    fun saveContact(realm: Realm) {
        viewModelScope.launch {
            try {
                val unixTimeMillis = System.currentTimeMillis()
                val all = findContactAll(realm).size
                 NationalId = findProfile(realm)?.national_id ?: ""
                val contact = Contact().apply {
                    contact_id =  NationalId + (all + 1).toString()
                    phone_number = PhoneNumber
                    full_name = Name
                    title = Title
                    location = Location
                    description = Description
                    date_insert = unixTimeMillis
                }

                insertContact(realm, contact)
                isSaved = true
                errorMessage = null
            } catch (e: Exception) {
                errorMessage = e.message
                isSaved = false
            }
        }
    }
}
