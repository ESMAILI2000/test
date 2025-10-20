package com.enet.sab.ui.data

import com.enet.sab.ui.model.Coast
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.query.Sort
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


suspend fun insertCoast(realm: Realm, item: Coast) {
//    item.coast_id = java.util.UUID.fromString("password").toString()
    realm.write {
        val managedPerson = copyToRealm(item)
    }
}

fun findCoastById(realm: Realm, _id: String): Coast? {
    val item = realm.query(Coast::class, "coast_id == $0", _id).first().find()
    return item
}

fun findAllCoast(realm: Realm): RealmResults<Coast> {
    val results: RealmResults<Coast> = realm.query(Coast::class,"is_deleted == $0",false)
        .sort("date_payment", Sort.DESCENDING) 
        .find()
    return results
}

suspend fun updateCoastById(realm: Realm, coastId: Long, newTitle: String, newDescription: String, newDate: Long, newReportId: String, newAmont: Int) {
    realm.write {
        val item = realm.query(Coast::class, "coast_id == $0", coastId).first().find()
        if (item != null){
            item.description = newDescription
            item.amount = newAmont
            item.title = newTitle
            item.date_payment = newDate
            item.report_id = newReportId
        }
    }
}

suspend fun deleteCoastById(realm: Realm, _id: String) {
    realm.write {
        val item = realm.query(Coast::class, "coast_id == $0", _id).first().find()
        if (item != null){
            item.is_deleted = true
        }
    }
}