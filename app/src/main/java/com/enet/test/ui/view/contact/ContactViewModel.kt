package com.enet.test.ui.view.contact

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enet.test.ui.data.ContactRepository
import com.enet.test.ui.model.Address
import com.enet.test.ui.model.Contact
import com.enet.test.ui.model.ImagePath
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kotlinx.coroutines.launch

class ContactViewModel : ViewModel() {

    private val realm = Realm.open(
        RealmConfiguration.Builder(schema = setOf(Contact::class, Address::class, ImagePath::class))
            .deleteRealmIfMigrationNeeded()
            .build()
    )

    private val repository = ContactRepository()

    val _contacts = mutableStateListOf<Contact>()
    val contacts: List<Contact> get() = _contacts

    var _id = mutableStateOf("")
    private val _selectedContact = mutableStateOf<Contact?>(null)
    val selectedContact: State<Contact?> = _selectedContact

    fun allContacts() {
        val results = repository.FindAllContact(realm)
        _contacts.clear()
        _contacts.addAll(results)
    }

    fun addContact(phone: String, name: String, age: Int, address: Address, imagePaths: List<String>) {
        viewModelScope.launch {
            repository.InsertContact(realm, phone, name, age, address, imagePaths)
            allContacts()
        }
    }

    fun findcontact() {
        viewModelScope.launch {
            val findcont = repository.FindContact(realm, _id.value+"")
            _selectedContact.value = findcont
        }
    }

    fun searchContacts(name: String) {
        viewModelScope.launch {
            val results = repository.searchContact(realm, name)
            _contacts.clear()
            _contacts.addAll(results)
        }
    }
}
