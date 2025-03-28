package com.devaeon.common.di

import com.devaeon.common.dispatchers.CoroutineDispatcherProvider
import com.devaeon.common.dispatchers.MainDispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CoroutineDispatcherModule {
    @Binds
    @Singleton
    fun provideDispatchers(dispatcher: MainDispatcherProvider): CoroutineDispatcherProvider
}
