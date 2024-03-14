@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.itbook.android.library)
  alias(libs.plugins.itbook.android.library.compose)
}

android {
  namespace = "com.jinukeu.core.designsystem"
}

dependencies {
  implementation(libs.kotlinx.immutable)
}
