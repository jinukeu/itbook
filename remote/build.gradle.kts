@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.itbook.android.remote)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "com.jinukeu.remote"
}

dependencies {
  implementation(projects.data)

  implementation(libs.retrofit.core)
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.kotlinx.datetime)
}
