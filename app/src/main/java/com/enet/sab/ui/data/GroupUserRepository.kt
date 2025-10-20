package com.enet.sab.ui.data

import com.enet.sab.ui.model.GroupUser
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


fun insertReportUser(realm: Realm, user: GroupUser) {
    realm.writeBlocking { // this : MutableRealm
        val managedPerson = copyToRealm(user)
    }
}

fun findGroupsAllByUserId(realm: Realm, userId: String): RealmResults<GroupUser> {
    return realm.query<GroupUser>("user_id == $0 AND is_deleted == false", userId).find()
}

fun findUsersAllByGroupId(realm: Realm, reportId: String): RealmResults<GroupUser> {
    return realm.query<GroupUser>("report_id == $0 AND is_deleted == false", reportId).find()
}

fun deleteGroupUserById(realm: Realm, reportUserId: String) {
    realm.writeBlocking {
        val user = query<GroupUser>("report_id == $0", reportUserId).first().find()
        user?.is_deleted = true
    }
}