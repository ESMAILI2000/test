package com.enet.test.ui.data

import com.enet.test.ui.model.Address
import com.enet.test.ui.model.Contact
import com.enet.test.ui.model.ImagePath
import io.realm.kotlin.Realm
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.query.Sort

class ContactRepository {

    suspend fun InsertContact(
        realm: Realm,
        phoneNumber: String,
        name: String,
        age: Int,
        address: Address,
        imagePaths: List<String>
    ) {
        // تبدیل رشته‌ها به آبجکت‌های ImagePath
        val imageObjects = imagePaths.map { path ->
            ImagePath().apply { uri = path }
        }
        val item = Contact().apply {
            phone_number = phoneNumber
            this.name = name
            this.age = age
            this.address = address
            this.images.addAll(imageObjects)
        }
        realm.write {
            copyToRealm(item)
        }
    }

    suspend fun UpdateUserById(
        realm: Realm,
        phoneNumber: String,
        name: String,
        age: Int,
        newImages: List<String>
    ) {
        val imageObjects = newImages.map { path ->
            ImagePath().apply { uri = path }
        }
        realm.write {
            val item = this.query(Contact::class, "phone_number == $0", phoneNumber).first().find()

            if (item != null) {
                findLatest(item)?.apply {
                    if (name.isNotEmpty()) {
                        this.name = name
                    }
                    this.age = age
                    newImages.let {
                        this.images.clear()
                        this.images.addAll(imageObjects)
                    }
                }
            }
        }
    }


    fun FindAllContact(realm: Realm): RealmResults<Contact> {
        return realm.query(Contact::class)
            .sort("age", Sort.DESCENDING)
            .find()
    }

    fun FindContact(realm: Realm, phoneNumber: String): Contact? {
        return realm.query(Contact::class, "phone_number == $0", phoneNumber).first().find()
    }

    fun filterContact(
        realm: Realm,
        minAge: Int? = null,
        maxAge: Int? = null,
        phoneNumber: String? = null,
        name: String? = null,
        bySort: String = "age",
        isDESCENDING: Boolean? = false
    ): List<Contact> {

        val firstOne = mutableListOf<String>()
        val secondOne = mutableListOf<Any>()

        if (minAge != null) {
            firstOne.add("age >= $${secondOne.size}")
            secondOne.add(minAge)
        }

        if (maxAge != null) {
            firstOne.add("age <= $${secondOne.size}")
            secondOne.add(maxAge)
        }

        if (phoneNumber != null) {
            firstOne.add("phone_number CONTAINS[c] $${secondOne.size}")
            secondOne.add(phoneNumber)
        }

        if (!name.isNullOrBlank()) {
            firstOne.add("name CONTAINS[c] $${secondOne.size}")
            secondOne.add(name)
        }

        val thirdOne = if (firstOne.isNotEmpty()) firstOne.joinToString(" AND ") else null
        val fourthOne = if (thirdOne != null)
            realm.query(Contact::class, thirdOne, *secondOne.toTypedArray())
        else
            realm.query(Contact::class)

        val results =
            fourthOne.sort(bySort, if (isDESCENDING == true) Sort.DESCENDING else Sort.ASCENDING)
                .find()

        return results
    }

    fun searchContact(
        realm: Realm,
        name: String? = null,
    ): List<Contact> {
        return realm.query(Contact::class, "name CONTAINS[c] $0", name)
            .sort("name", Sort.DESCENDING)
            .find()
    }
}


