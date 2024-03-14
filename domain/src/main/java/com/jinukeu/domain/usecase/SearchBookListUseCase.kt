package com.jinukeu.domain.usecase

import com.jinukeu.core.common.runCatchingIgnoreCancelled
import com.jinukeu.core.model.BookCollection
import com.jinukeu.domain.repository.BookRepository
import javax.inject.Inject

class SearchBookListUseCase @Inject constructor(
  private val bookRepository: BookRepository,
) {
  suspend operator fun invoke(
    query: String = "",
    page: Int = 1,
  ): Result<BookCollection> = runCatchingIgnoreCancelled {
    bookRepository.searchBookList(
      query = query,
      page = page,
    )
  }
}
