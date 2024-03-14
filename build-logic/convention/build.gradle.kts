@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  `kotlin-dsl`
}

group = "com.jinukeu.buildlogic.convention"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
  compileOnly(libs.android.gradle.plugin)
  compileOnly(libs.kotlin.gradle.plugin)
  compileOnly(libs.ksp.gradle.plugin)
}

gradlePlugin {
  plugins {
    register("androidApplication") {
      id = "itbook.android.application"
      implementationClass = "AndroidApplicationConventionPlugin"
    }
    register("androidApplicationCompose") {
      id = "itbook.android.application.compose"
      implementationClass = "AndroidApplicationComposeConventionPlugin"
    }
    register("androidLibrary") {
      id = "itbook.android.library"
      implementationClass = "AndroidLibraryConventionPlugin"
    }
    register("androidLibraryCompose") {
      id = "itbook.android.library.compose"
      implementationClass = "AndroidLibraryComposeConventionPlugin"
    }
    register("androidHilt") {
      id = "itbook.android.hilt"
      implementationClass = "AndroidHiltConventionPlugin"
    }
    register("javaLibrary") {
      id = "itbook.java.library"
      implementationClass = "JavaLibraryConventionPlugin"
    }
    register("featureCompose") {
      id = "itbook.android.feature.compose"
      implementationClass = "FeatureComposeConventionPlugin"
    }
    register("remote") {
      id = "itbook.android.remote"
      implementationClass = "RemoteConventionPlugin"
    }
    register("data") {
      id = "itbook.android.data"
      implementationClass = "DataConventionPlugin"
    }
  }
}
