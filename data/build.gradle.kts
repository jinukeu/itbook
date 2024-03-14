@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.itbook.android.data)
}

android {
  namespace = "com.jinukeu.data"
}

dependencies {
  implementation(projects.domain)
}
