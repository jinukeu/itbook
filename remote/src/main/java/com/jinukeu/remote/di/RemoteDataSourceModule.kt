package com.jinukeu.remote.di

import com.jinukeu.data.datasource.RemoteBookDataSource
import com.jinukeu.remote.datasource.RemoteBookDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

  @Singleton
  @Binds
  abstract fun bindRemoteBookDatasource(
    remoteBookDataSourceImpl: RemoteBookDataSourceImpl,
  ): RemoteBookDataSource
}
