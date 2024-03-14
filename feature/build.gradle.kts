@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.itbook.android.feature.compose)
}

android {
  namespace = "com.jinukeu.feature"
}

dependencies {
  implementation(projects.domain)
  implementation(libs.kotlinx.serialization.json)
}
