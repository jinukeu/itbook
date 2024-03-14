package com.jinukeu.feature

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jinukeu.feature.home.HomeRoute

@Composable
internal fun MainScreen(
  modifier: Modifier = Modifier,
  navigator: MainNavigator = rememberMainNavigator(),
) {
  Scaffold(
    modifier = modifier,
    content = { innerPadding ->
      NavHost(
        navController = navigator.navController,
        startDestination = navigator.startDestination,
      ) {
        composable(route = MainRoute.homeRoute) {
          HomeRoute(padding = innerPadding)
        }
      }
    },
  )
}
