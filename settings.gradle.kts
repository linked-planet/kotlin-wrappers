pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
    }
}

rootProject.name = "kotlin-wrappers"

include("kotlin-atlaskit")