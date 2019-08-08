plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

dependencies {
    implementation("nu.studer:gradle-credentials-plugin:1.0.7")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:0.9.18")
}