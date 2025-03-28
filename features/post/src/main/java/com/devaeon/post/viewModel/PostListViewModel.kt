package com.devaeon.post.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devaeon.common.dispatchers.CoroutineDispatcherProvider
import com.devaeon.common.fold
import com.devaeon.core.domain.usecase.GetAllPostsUseCase
import com.devaeon.post.intent.PostListIntent
import com.devaeon.post.state.PostListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val dispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    private val _state = MutableStateFlow<PostListState>(PostListState.Loading)
    val state: StateFlow<PostListState> get() = _state

    init {
        handleIntent(PostListIntent.LoadPosts)
    }

    fun handleIntent(intent: PostListIntent) {
        when (intent) {
            is PostListIntent.LoadPosts -> loadPosts()
        }
    }

    private fun loadPosts() {
        viewModelScope.launch(dispatcherProvider.io) {
            _state.update { PostListState.Loading }
            getAllPostsUseCase().fold(
                onSuccess = { newPosts -> _state.update { PostListState.Success(posts = newPosts) } },
                onError = { message, _ -> _state.update { PostListState.Error(message) } }
            )
        }
    }
}