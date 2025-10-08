package com.enet.test.ui.model

import com.google.gson.annotations.SerializedName

data class ObjectRequest( // مدل درخواست در api ساخت آبجکت جدید
    val name: String,
    val data: ObjectData,
)

data class ObjectResponse(  // مدل پاسخ api
    val name: String,
    val data: ObjectData,
    val createdAt: String,
)

data class ObjectData (
    val year: Int,
    val price: Double,
   @SerializedName("CPU model") val cPUmodel : String,  // برای فاصله ای که در نام متغیر است
   @SerializedName("Hard disk size") val hardSize : String,
)