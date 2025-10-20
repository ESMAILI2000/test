package com.enet.sab.ui.model

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Group : RealmObject {
    @PrimaryKey
    var group_id: String = ""
    var unit_id: String = ""
    var name: String = ""
    var date_insert: Long=0L
    var collocation_id: String = ""
    var manager_id: String = ""
    var is_deleted: Boolean = false
}
