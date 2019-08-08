pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenLocal()
        jcenter()
        maven { url = uri("http://dl.bintray.com/kotlin/kotlin-eap") }
    }
}

rootProject.name = "kotlin-wrappers"

include("kotlin-atlaskit")