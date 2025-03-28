package com.devaeon.core.domain.di

import com.devaeon.core.domain.repository.PostRepository
import com.devaeon.core.domain.usecase.DeletePostUseCase
import com.devaeon.core.domain.usecase.GetPostByPostIdUseCase
import com.devaeon.core.domain.usecase.GetAllPostsUseCase
import com.devaeon.core.domain.usecase.GetPostsByUserIdUseCase
import com.devaeon.core.domain.usecase.InsertPostUseCase
import com.devaeon.core.domain.usecase.UpdatePostUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetPostByPostIdUseCase(postRepository: PostRepository): GetPostByPostIdUseCase {
        return GetPostByPostIdUseCase(postRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetAllPostsUseCase(postRepository: PostRepository): GetAllPostsUseCase {
        return GetAllPostsUseCase(postRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetPostsByUserIdUseCase(postRepository: PostRepository): GetPostsByUserIdUseCase {
        return GetPostsByUserIdUseCase(postRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideInsertPostUseCase(postRepository: PostRepository): InsertPostUseCase {
        return InsertPostUseCase(postRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideUpdatePostUseCase(postRepository: PostRepository): UpdatePostUseCase {
        return UpdatePostUseCase(postRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideDeletePostUseCase(postRepository: PostRepository): DeletePostUseCase {
        return DeletePostUseCase(postRepository)
    }
}