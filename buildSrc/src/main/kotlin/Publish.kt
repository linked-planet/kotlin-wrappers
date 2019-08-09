import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.kotlin.dsl.task

fun Project.applyAllPublishing(name: String, description: String) {
    applyMavenCentralPublishing(name, description)
    applyNpmPublishing()
    task("prepublish", Task::class) {
        dependsOn("npmPrepublish", "mavenPrepublish")
    }
}