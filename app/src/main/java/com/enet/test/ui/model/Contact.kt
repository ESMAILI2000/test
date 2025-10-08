package com.enet.test.ui.model

import androidx.compose.runtime.MutableState
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class Contact : RealmObject {
    @PrimaryKey
    var phone_number: String = ""
    var name: String = ""
    var age: Int = 0
    var address: Address? = null
    var images: RealmList<ImagePath> = realmListOf()
}

class ImagePath : RealmObject {
    var uri: String = ""
}
//open class Address : RealmObject {
//    var title: String = ""
//    var location: String = ""
//}

open class Address : RealmObject {
    var state: String = ""
    var city: String = ""
    var street: String = ""
    var allip: String = ""
    var plat: String = ""
}