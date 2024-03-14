import com.jinukeu.buildlogic.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

internal class DataConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("itbook.android.library")
        apply("itbook.android.hilt")
      }

      dependencies {
        "implementation"(project(":core:model"))
        "implementation"(libs.findBundle("coroutine").get())

        "androidTestImplementation"(libs.findLibrary("junit").get())
        "implementation"(libs.findLibrary("timber").get())
      }
    }
  }
}
