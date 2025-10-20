package com.enet.sab.ui.model

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Coast : RealmObject {
    @PrimaryKey
    var coast_id: String = ""
    var report_id: String = ""
    var unit_name: String = ""
    var date_insert: Long=0L // تاریخ ثبت
    var date_payment: Long=0L // تاریخ پرداخت
    var amount: Int=0 //هزینه دریافتی عدد مثبت و هزینه پرداختی عدد منفی
    var description: String = ""
    var title: String = ""
    var is_deleted: Boolean = false
}