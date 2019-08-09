apply { from("../versions.gradle.kts") }

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    maven { url = uri("http://dl.bintray.com/kotlin/kotlin-eap") }
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

dependencies {
    implementation("nu.studer:gradle-credentials-plugin:${property("gradle_credentials_plugin_version")}")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:${property("dokka_gradle_plugin_version")}")
    implementation("com.bmuschko:gradle-nexus-plugin:${property("gradle_nexus_plugin_version")}")
    implementation("org.jetbrains.kotlin:kotlin-frontend-plugin:${property("kotlin_frontend_plugin_version")}")
}