package com.cocinamingle.network.impl.di

import com.cocinamingle.network.api.interceptors.AuthorizationInterceptor
import com.cocinamingle.network.impl.interceptor.AuthorizationInterceptorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {

    @Binds
    @Singleton
    abstract fun bindAuthorizationInterceptor(
        authorizationInterceptorImpl: AuthorizationInterceptorImpl
    ): AuthorizationInterceptor
}

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}