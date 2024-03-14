@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.itbook.android.library)
  alias(libs.plugins.itbook.android.hilt)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "com.jinukeu.core.network"

  buildTypes {
    getByName("debug") {
      buildConfigField("String", "BASE_URL", "\"https://api.itbook.store/1.0/\"")
    }

    getByName("release") {
      buildConfigField("String", "BASE_URL", "\"https://api.itbook.store/1.0/\"")
    }
  }
}

dependencies {
  implementation(projects.core.model)

  implementation(libs.bundles.coroutine)
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.retrofit.core)
  implementation(libs.retrofit.kotlin.serialization)
  implementation(libs.okhttp.logging)

  implementation(libs.timber)
}
