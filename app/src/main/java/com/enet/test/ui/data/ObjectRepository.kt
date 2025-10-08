package com.enet.test.ui.data

import com.enet.test.ui.api.ApiTest
import com.enet.test.ui.model.ObjectRequest
import com.enet.test.ui.model.ObjectResponse

class ObjectRepository {
    suspend fun sendObject(objectRequest: ObjectRequest): ObjectResponse{
        return ApiTest.apiObject.newObject(objectRequest)
    }
}