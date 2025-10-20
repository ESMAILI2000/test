package com.enet.sab.ui.model

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


class Report : RealmObject {
    @PrimaryKey
    var report_id: Long = 0L
    var unit_id: Long = 0L
    var manager_name: String = "" // نام مسئول برگزاری
    var manager_id: String = ""
    var location: String = "" // مکان برگزاری
    var date_insert: Long=0L // تاریخ ثبت
    var date_lunch: Long=0L // تاریخ برگزاری
    var time_start: Long=0L // ساعت شروع
    var time_end: Long=0L // ساعت پایان
    var description: String = ""
    var title: String = ""
    var is_deleted: Boolean = false
}
