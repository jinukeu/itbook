package com.jinukeu.data.di

import com.jinukeu.data.repository.BookRepositoryImpl
import com.jinukeu.domain.repository.BookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

  @Singleton
  @Binds
  abstract fun bindBookRepository(
    bookRepositoryImpl: BookRepositoryImpl,
  ): BookRepository
}
