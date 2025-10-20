package com.enet.sab.ui.model

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Profile : RealmObject {
    @PrimaryKey
    var national_id: String = ""
    var password: String = ""
    var level_permission: Int = 2 //سطح دسترسی 0=> فرمانده | 1=> اعضای اصلی | 2=> اعضای فرعی
}

