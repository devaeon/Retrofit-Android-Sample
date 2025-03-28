package com.devaeon.core.data.di

import com.devaeon.core.data.service.PostService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import kotlin.jvm.java

@Module
@InstallIn(ViewModelComponent::class)
object ApiModule {
    @Provides
    @ViewModelScoped
    fun providePostService(retrofit: Retrofit): PostService {
        return retrofit.create(PostService::class.java)
    }

}
