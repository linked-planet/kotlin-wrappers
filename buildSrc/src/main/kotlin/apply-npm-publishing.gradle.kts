apply {
    plugin("com.github.node-gradle.node")
}

task("processPkg", Copy::class) {
    from(".")
    into("build/npm")
    include("package.json")
    expand(mapOf(
            "kotlin_version" to property("kotlin_version"),
            "react_version" to property("react_version")
    ))
}

task("npmPrepublish", Copy::class) {
    from(".")
    into("build/npm")
    exclude("package.json")
    exclude("build/npm")
    exclude("build/javadoc")
}

tasks.getByName("npm_publish") {
    withGroovyBuilder {
        "setArgs"(listOf("--access", "public"))
        "execOverrides" {
            "it.workingDir"("build/npm")
        }
    }
}

tasks.getByName("npm_publish").dependsOn("npmPrepublish")
tasks.getByName("npm_publish").dependsOn("processPkg")
tasks.getByName("npmPrepublish").dependsOn("build")
