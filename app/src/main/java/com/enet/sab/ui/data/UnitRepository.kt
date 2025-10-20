package com.enet.sab.ui.data

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import com.enet.sab.ui.model.Unit



fun insertUnit(realm: Realm, user: Unit) {
    realm.writeBlocking { // this : MutableRealm
        val managedPerson = copyToRealm(user)
    }
}

fun findUnitById(realm: Realm, unitId: String): Unit? {
    return realm.query<Unit>("unit_id == $0", unitId).first().find()
}

fun findUnitAll(realm: Realm): RealmResults<Unit> {
    return realm.query<Unit>("is_deleted == false").find()
}

fun findUnitAllByCollocationId(realm: Realm, CollocationId: String): RealmResults<Unit> {
    return realm.query<Unit>("collocation_id == $0 AND is_deleted == false", CollocationId).find()
}

fun updateUnitById(realm: Realm, UnitId: String, newName: String, newManagerId: String) {
    realm.writeBlocking {
        val user = query<Unit>("unit_id == $0", UnitId).first().find()
        user?.name = newName
        user?.manager_id= newManagerId
    }
}

fun deleteUnitById(realm: Realm, UnitId: String) {
    realm.writeBlocking {
        val user = query<Unit>("unit_id == $0", UnitId).first().find()
        user?.is_deleted = true
    }
}