import com.jinukeu.buildlogic.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

internal class FeatureComposeConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("itbook.android.library")
        apply("itbook.android.library.compose")
        apply("itbook.android.hilt")
      }

      dependencies {
        "implementation"(project(":core:model"))
        "implementation"(project(":core:ui"))
        "implementation"(project(":core:designsystem"))

        "implementation"(libs.findLibrary("kotlinx.immutable").get())
        "implementation"(libs.findLibrary("kotlinx.coroutines.android").get())
        "implementation"(libs.findLibrary("kotlinx.coroutines.core").get())

        "androidTestImplementation"(libs.findLibrary("junit").get())
        "implementation"(libs.findLibrary("timber").get())
      }
    }
  }
}
