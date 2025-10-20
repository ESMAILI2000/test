package com.enet.sab.ui.model

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Contact : RealmObject {
    @PrimaryKey
    var contact_id: String = ""
    var phone_number: String = ""
    var full_name: String = ""
    var date_insert: Long=0L
    var location: String = ""
    var title: String = ""
    var description: String = ""
    var is_deleted: Boolean = false
}