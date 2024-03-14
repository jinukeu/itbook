package com.jinukeu.domain.usecase

import com.jinukeu.core.common.runCatchingIgnoreCancelled
import com.jinukeu.core.model.BookDetail
import com.jinukeu.domain.repository.BookRepository
import javax.inject.Inject

class GetBookDetailUseCase @Inject constructor(
  private val bookRepository: BookRepository,
) {
  suspend operator fun invoke(
    isbn13: String,
  ): Result<BookDetail> = runCatchingIgnoreCancelled {
    bookRepository.getBookDetail(
      isbn13 = isbn13,
    )
  }
}
