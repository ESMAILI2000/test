package com.enet.test.ui.api

import com.enet.test.ui.model.ObjectRequest
import com.enet.test.ui.model.ObjectResponse
import com.enet.test.ui.model.Post
import okhttp3.Response
import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ObjectApi {
    @POST("objects")  // آدرس ساخت آبجکت جدید
    suspend fun newObject(@Body objectRequest: ObjectRequest): ObjectResponse
}