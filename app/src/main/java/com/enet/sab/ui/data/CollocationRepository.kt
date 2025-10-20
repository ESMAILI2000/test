package com.enet.sab.ui.data

import com.enet.sab.ui.model.Collocation
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

fun insertCollocation(realm: Realm, user: Collocation) {
    realm.writeBlocking { // this : MutableRealm
        //java.util.UUID.randomUUID().toString()
        val managedPerson = copyToRealm(user)
    }
}

fun findCollocationById(realm: Realm, contactId: String): Collocation? {
    return realm.query<Collocation>("collocation_id == $0", contactId).first().find()
}

fun findCollocationAll(realm: Realm): RealmResults<Collocation> {
    return realm.query<Collocation>().find()
}



