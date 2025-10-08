package com.enet.test.ui.api

import com.enet.test.ui.model.Hapoo
import com.enet.test.ui.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {
    @GET("/posts") // request
    suspend fun getPosts(): List<Post> // response

    @GET("/comments") // request
    suspend fun getComments(): List<Post> // response
}