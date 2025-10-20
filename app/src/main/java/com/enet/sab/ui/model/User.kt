package com.enet.sab.ui.model

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class User : RealmObject {
    @PrimaryKey
    var national_id: String = ""
    var first_name: String = ""
    var last_name: String = ""
    var date_joined: Long=0L
    var date_of_birth: Long = 0L
    var father_name: String = ""
    var phone_number: String = ""
    var home_location: String = ""
    var father_phone_number: String = ""
    var mother_phone_number: String = ""
    var home_phone_number: String = ""
    var skill: String = ""
    var is_deleted: Boolean = false
    var is_active: Boolean = false
}