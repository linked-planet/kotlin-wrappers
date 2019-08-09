import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

apply {
    plugin("kotlin2js")
}

val kotlinVersion = property("kotlin_version")
dependencies.add("implementation", "org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVersion")

tasks.getByName("compileKotlin2Js", Kotlin2JsCompile::class) {
    kotlinOptions {
        metaInfo = true
        outputFile = "${project.buildDir.path}/classes/main/${project.name}.js"
        moduleKind = "commonjs"
        sourceMap = true
        sourceMapEmbedSources = "always"
    }
}
