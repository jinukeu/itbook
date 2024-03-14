plugins {
  alias(libs.plugins.itbook.android.application)
  alias(libs.plugins.itbook.android.application.compose)
  alias(libs.plugins.itbook.android.hilt)
}

android {
  namespace = "com.jinukeu.itbook"

  defaultConfig {
    applicationId = "com.jinukeu.itbook"
    versionCode = 1
    versionName = "1.0"
  }
}

dependencies {
  implementation(projects.data)
  implementation(projects.remote)
  implementation(projects.feature)

  implementation(libs.timber)
}
