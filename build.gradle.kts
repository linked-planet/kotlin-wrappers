buildscript {
    project.apply {
        from("versions.gradle.kts")
    }
    val kotlinVersion = project.property("kotlin_version").toString()
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.github.node-gradle:gradle-node-plugin:1.5.3")
    }
}

plugins {
    id("com.github.hierynomus.license") version "0.15.0"
    id("com.github.hierynomus.license-report") version "0.15.0"
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
