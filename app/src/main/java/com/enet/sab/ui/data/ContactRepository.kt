package com.enet.sab.ui.data

import com.enet.sab.ui.model.Contact
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey





suspend fun insertContact(realm: Realm, user: Contact): Result<Contact> {
    return runCatching {
        realm.write {
            copyToRealm(user)
        }
    }
}


fun findContactById(realm: Realm, contactId: String): Contact? {
    return realm.query<Contact>("contact_id == $0", contactId).first().find()
}

fun findContactAll(realm: Realm): RealmResults<Contact> {
    return realm.query<Contact>("is_deleted == false").find()
}

fun updateContactById(realm: Realm, contactId: String, newFullName: String, newLocation: String, newTitle: String, newDescription: String) {
    realm.writeBlocking {
        val user = query<Contact>("contact_id == $0", contactId).first().find()
        user?.full_name = newFullName
        user?.location= newLocation
        user?.title = newTitle
        user?.description = newDescription
    }
}

fun deleteContactById(realm: Realm, contactId: String) {
    realm.writeBlocking {
        val user = query<Contact>("contact_id == $0", contactId).first().find()
        user?.is_deleted = true
    }
}