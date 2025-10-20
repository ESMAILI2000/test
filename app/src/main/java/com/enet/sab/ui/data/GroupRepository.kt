package com.enet.sab.ui.data

import com.enet.sab.ui.model.Group
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


fun insertGroup(realm: Realm, user: Group) {
    realm.writeBlocking { // this : MutableRealm
        val managedPerson = copyToRealm(user)
    }
}

fun findGroupById(realm: Realm, GroupId: String): Group? {
    return realm.query<Group>("group_id == $0", GroupId).first().find()
}

fun findGroupAll(realm: Realm): RealmResults<Group> {
    return realm.query<Group>("is_deleted == false").find()
}

fun findGroupAllByUnitId(realm: Realm, UnitId: String): RealmResults<Group> {
    return realm.query<Group>("unit_id == $0 AND is_deleted == false", UnitId).find()
}

fun updateGroupById(realm: Realm, GroupId: String, newName: String, newManagerId: String) {
    realm.writeBlocking {
        val user = query<Group>("group_id == $0", GroupId).first().find()
        user?.name = newName
        user?.manager_id= newManagerId
    }
}

fun deleteGroupById(realm: Realm, GroupId: String) {
    realm.writeBlocking {
        val user = query<Group>("group_id == $0", GroupId).first().find()
        user?.is_deleted = true
    }
}