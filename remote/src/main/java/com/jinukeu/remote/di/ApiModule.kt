package com.jinukeu.remote.di

import com.jinukeu.remote.api.BookApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

  @Singleton
  @Provides
  fun provideBookApi(retrofit: Retrofit): BookApi {
    return retrofit.create(BookApi::class.java)
  }
}
