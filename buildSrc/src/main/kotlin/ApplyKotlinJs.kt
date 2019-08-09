import org.gradle.api.Project
import org.gradle.kotlin.dsl.withGroovyBuilder

fun Project.applyKotlinJs(dependencies: List<String>) {
    val kotlinVersion = property("kotlin_version")

    apply {
        plugin("kotlin2js")
    }

    val allDependencies = dependencies + "org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVersion"
    allDependencies.forEach { this.dependencies.add("implementation", it) }

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
