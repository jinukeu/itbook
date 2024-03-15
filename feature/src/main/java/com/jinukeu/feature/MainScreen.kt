package com.jinukeu.feature

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jinukeu.feature.bookdetail.BookDetailRoute
import com.jinukeu.feature.home.HomeRoute
import kotlinx.coroutines.launch
import java.net.UnknownHostException

@Composable
internal fun MainScreen(
  modifier: Modifier = Modifier,
  navigator: MainNavigator = rememberMainNavigator(),
) {
  val snackBarHostState = remember { SnackbarHostState() }
  val coroutineScope = rememberCoroutineScope()
  val context = LocalContext.current

  val onShowErrorSnackBar: (throwable: Throwable?, retry: (() -> Unit)?) -> Unit = { throwable, retry ->
    coroutineScope.launch {
      val snackbarResult = snackBarHostState.showSnackbar(
        message = when (throwable) {
          is UnknownHostException -> context.getString(R.string.snackbar_network_error_message)
          else -> throwable?.message ?: context.getString(R.string.snackbar_unknown_error_message)
        },
        actionLabel = if (retry == null) null else context.getString(R.string.snackbar_retry_action_label),
        withDismissAction = true,
      )
      when (snackbarResult) {
        SnackbarResult.Dismissed -> {}
        SnackbarResult.ActionPerformed -> retry?.invoke()
      }
    }
  }

  Scaffold(
    modifier = modifier,
    snackbarHost = { SnackbarHost(snackBarHostState) },
    content = { innerPadding ->
      NavHost(
        navController = navigator.navController,
        startDestination = navigator.startDestination,
      ) {
        composable(route = MainRoute.homeRoute) {
          HomeRoute(
            padding = innerPadding,
            navigateBookDetail = navigator::navigateBookDetail,
            onShowErrorSnackBar = onShowErrorSnackBar,
          )
        }

        composable(
          route = MainRoute.bookDetailRoute("{${MainRoute.BOOK_DETAIL_ARGUMENT}}"),
        ) {
          BookDetailRoute(
            onShowErrorSnackBar = onShowErrorSnackBar,
          )
        }
      }
    },
  )
}
