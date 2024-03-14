import com.android.build.gradle.LibraryExtension
import com.jinukeu.buildlogic.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.android.library")
      }

      extensions.configure<LibraryExtension> {
        configureAndroidCompose(this)
      }
    }
  }
}
