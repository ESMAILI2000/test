package com.enet.test.ui.view.post

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enet.test.ui.data.PostRepository
import com.enet.test.ui.model.Post
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val repository = PostRepository()

    var posts = mutableStateListOf<Post>()
        private set

    // برای اینکه هنگام ورود به صفحه تابع اجرا بشود
    init {
        fetchPosts()
       }

    private fun fetchPosts() {
        viewModelScope.launch {
                val result = repository.getPosts()
                posts.clear()
                posts.addAll(result)
        }
    }
}
