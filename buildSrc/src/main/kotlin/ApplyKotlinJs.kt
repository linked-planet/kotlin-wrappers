import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withGroovyBuilder

class ApplyKotlinJs : Plugin<Project> {

    override fun apply(target: Project) {
        target.apply<Project> {
            val kotlinVersion = property("kotlin_version")
            dependencies.add(
                    "implementation",
                    "org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVersion")

            tasks.getByName("compileKotlin2Js") {
                withGroovyBuilder {
                    "kotlinOptions" {
                        "setMetaInfo"(true)
                        "setOutputFile"("${project.buildDir.path}/classes/main/${project.name}.js")
                        "setModuleKind"("commonjs")
                        "setSourceMap"(true)
                        "setSourceMapEmbedSources"("always")
                    }
                }
            }
        }
    }

}
