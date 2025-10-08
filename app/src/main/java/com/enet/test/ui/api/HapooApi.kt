package com.enet.test.ui.api

import com.enet.test.ui.model.Hapoo
import com.enet.test.ui.model.Post
import retrofit2.http.GET

interface GetHapoo {
    @GET("image/random") // request
    suspend fun gethapoo(): Hapoo // response
}