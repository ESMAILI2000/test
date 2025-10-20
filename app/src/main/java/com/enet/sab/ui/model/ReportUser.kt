package com.enet.sab.ui.model

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class ReportUser : RealmObject {
    @PrimaryKey
    var id: Long = 0L
    var report_id: Long = 0L
    var user_id: String = ""
    var user_first_name: String = ""
    var user_last_name: String = ""
    var date_insert: Long=0L // تاریخ ثبت
    var report_date_lunch: Long=0L // تاریخ برگزاری
    var is_deleted: Boolean = false
}
// احتمالا در ساختار جدید نیازی به این جدول نیست