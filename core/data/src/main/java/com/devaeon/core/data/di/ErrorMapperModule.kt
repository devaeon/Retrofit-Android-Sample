package com.devaeon.core.data.di

import com.devaeon.common.ErrorMapper
import com.devaeon.core.data.mapper.ErrorMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ErrorMapperModule {

    @Binds
    @Singleton
    abstract fun bindErrorMapper(errorMapperImpl: ErrorMapperImpl): ErrorMapper
}