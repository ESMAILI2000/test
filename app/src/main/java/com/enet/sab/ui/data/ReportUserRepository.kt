package com.enet.sab.ui.data

import com.enet.sab.ui.model.Report
import com.enet.sab.ui.model.ReportUser
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

fun insertReportUser(realm: Realm, user: ReportUser) {
    realm.writeBlocking { // this : MutableRealm
        val managedPerson = copyToRealm(user)
    }
}

fun findReportsByUserId(realm: Realm, userId: String): RealmResults<Report> {
    val userReports = realm.query<ReportUser>("user_id == $0", userId).find()
    val reportIds = userReports.map { it.report_id } // استخراج آیدی گزارش‌ها
    return realm.query<Report>("report_id IN $0 AND is_deleted == false", reportIds).find()
}

fun findUsersByReportId(realm: Realm, reportId: String): RealmResults<User> {
    val userReports = realm.query<ReportUser>("report_id == $0", reportId).find()
    val userIds = userReports.map { it.user_id } // استخراج آیدی کاربرها
    return realm.query<User>("user_id IN $0 AND is_deleted == false", userIds).find()
}

fun deleteReportUserById(realm: Realm, reportUserId: String) {
    realm.writeBlocking {
        val user = query<ReportUser>("id == $0", reportUserId).first().find()
        user?.is_deleted = true
    }
}