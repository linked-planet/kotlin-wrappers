apply {
    plugin("kotlin2js")
}

val kotlinVersion = property("kotlin_version")
dependencies.add("implementation", "org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVersion")

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
