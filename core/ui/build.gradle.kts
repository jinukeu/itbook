@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.itbook.android.library)
  alias(libs.plugins.itbook.android.library.compose)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "com.jinukeu.core.ui"
}
dependencies {
  implementation(libs.kotlinx.immutable)
  implementation(libs.kotlinx.serialization.json)
}
