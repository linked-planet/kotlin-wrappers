buildscript {
    project.apply { from("versions.gradle.kts") }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("kotlin_version")}")
        classpath("com.github.node-gradle:gradle-node-plugin:${property("gradle_node_plugin_version")}")
        classpath("com.bmuschko:gradle-nexus-plugin:${property("gradle_nexus_plugin_version")}")
        classpath("io.codearte.gradle.nexus:gradle-nexus-staging-plugin:${property("gradle_nexus_staging_plugin_version")}")
        classpath("nu.studer:gradle-credentials-plugin:${property("gradle_credentials_plugin_version")}")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:${property("dokka_gradle_plugin_version")}")
    }
}

plugins {
    id("com.github.hierynomus.license") version "0.15.0"
    id("com.github.ben-manes.versions") version "0.21.0"
}

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("http://dl.bintray.com/kotlin/kotlinx.html") }
        maven { url = uri("http://dl.bintray.com/kotlin/ktor") }
        maven { url = uri("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
        maven { url = uri("https://kotlin.bintray.com/kotlinx") }
        maven { url = uri("http://dl.bintray.com/kotlin/kotlin-eap") }
    }

    group = "com.link-time.kotlin"
}
