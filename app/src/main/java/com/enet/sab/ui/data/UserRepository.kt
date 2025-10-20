package com.enet.sab.ui.data

import com.enet.sab.ui.model.User
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

fun insertMember(realm: Realm, user: User) {
    realm.writeBlocking { // this : MutableRealm
        val managedPerson = copyToRealm(user)
    }
}

fun findUserById(realm: Realm, userId: String): User? {
    return realm.query<User>("national_id == $0", userId).first().find()
}

fun findUserAll(realm: Realm): RealmResults<User> {
    return realm.query<User>("is_deleted == false").find()
}

fun updateUserById(realm: Realm, userId: String, newFirstName: String , newLastName: String, newPhoneNumber: String, newDateOfBirth: Long) {
    realm.writeBlocking {
        val user = query<User>("national_id == $0", userId).first().find()
        user?.first_name = newFirstName
        user?.last_name= newLastName
        user?.phone_number = newPhoneNumber
        user?.date_of_birth = newDateOfBirth
    }
}

fun deleteUserById(realm: Realm, userId: String) {
    realm.writeBlocking {
        val user = query<User>("national_id == $0", userId).first().find()
        user?.is_deleted = true
    }
}