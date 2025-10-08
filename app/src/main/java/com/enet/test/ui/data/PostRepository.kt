package com.enet.test.ui.data

import com.enet.test.ui.api.ApiTest
import com.enet.test.ui.model.Hapoo
import com.enet.test.ui.model.ObjectRequest
import com.enet.test.ui.model.Post

class PostRepository {
    suspend fun getPosts(): List<Post> {
        return ApiTest.apiPost.getPosts()
    }

}