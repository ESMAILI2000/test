package com.enet.sab.ui.data

import com.enet.sab.ui.model.Report
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


fun insertReport(realm: Realm, user: Report) {
    realm.writeBlocking { // this : MutableRealm
        val managedPerson = copyToRealm(user)
    }
}

fun findReportById(realm: Realm, reportId: String): Report? {
    return realm.query<Report>("report_id == $0", reportId).first().find()
}

fun findReportAll(realm: Realm): RealmResults<Report> {
    return realm.query<Report>("is_deleted == false").find()
}

fun updateReportById(realm: Realm, reportId: Long, newTitle: String, newLacation: String, newDescription: String, newDate: Long, newStartTime: Long,
                     newEndTime: Long, newManagerId: String, newManagerName: String) {
    realm.writeBlocking {
        val user = query<Report>("report_id == $0", reportId).first().find()
        user?.description = newDescription
        user?.date_lunch = newDate
        user?.time_start = newStartTime
        user?.time_end = newEndTime
        user?.title = newTitle
        user?.location = newLacation
        user?.manager_id = newManagerId
        user?.manager_name = newManagerName
    }
}

fun deleteReportById(realm: Realm, reportId: String) {
    realm.writeBlocking {
        val user = query<Report>("report_id == $0", reportId).first().find()
        user?.is_deleted = true
    }
}