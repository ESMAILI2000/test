package com.enet.sab.ui.data

import com.enet.sab.ui.model.Profile
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

fun insertProfile(realm: Realm, profile: Profile) {
    realm.writeBlocking { // this : MutableRealm
        val managedPerson = copyToRealm(profile)
    }
}

    fun findProfile(realm: Realm): Profile? {
        return realm.query<Profile>().first().find()
    }

    fun updatePassword(realm: Realm, newPassword: String) {
        realm.writeBlocking {
            val user = query<Profile>().first().find()
                user?.password = newPassword
        }
    }

    fun updateLevelPermission(realm: Realm,  newLvelPermission: Int) {
        realm.writeBlocking {
            val user = query<Profile>().first().find()
            user?.level_permission = newLvelPermission
        }
    }

