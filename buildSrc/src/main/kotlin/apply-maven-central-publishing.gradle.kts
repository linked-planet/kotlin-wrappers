import com.bmuschko.gradle.nexus.ExtraArchivePluginExtension
import groovy.lang.Closure
import nu.studer.gradle.credentials.domain.CredentialsContainer
import org.jetbrains.dokka.gradle.DokkaTask

extra.apply {
    set("gnsp.disableApplyOnlyOnRootProjectEnforcement", true)
}

apply {
    plugin("com.bmuschko.nexus")
    plugin("io.codearte.nexus-staging")
    plugin("nu.studer.credentials")
    plugin("org.jetbrains.dokka")
}

// obtain passwords from gradle credentials plugin
gradle.taskGraph.whenReady {
    if (allTasks.any { it is Sign }) {
        val credentials: CredentialsContainer by extra
        allprojects {
            extra["signing.password"] = credentials.getProperty("signingPassword")
        }
    }
    if (allTasks.any {
                it.name in setOf("uploadArchives", "closeRepository", "releaseRepository", "closeAndReleaseRepository")
            }) {
        val credentials: CredentialsContainer by extra
        allprojects {
            extra["nexusPassword"] = credentials.getProperty("nexusToken")
        }
    }
}

// add pom metadata needed for publishing to maven central
val extension = project.extensions.create<MavenCentralPublishingExtension>("mavenCentralPublishing")
val modifyPom: Closure<MavenPom> by extra
modifyPom(closureOf<MavenPom> {
    project {
        withGroovyBuilder {
            "name"(extension.name)
            "description"(extension.description)
            "url"("https://github.com/link-time/kotlin-wrappers/tree/master/${project.name}")
            "inceptionYear"("2019")
            "licenses" {
                "license" {
                    "name"("The Apache Software License, Version 2.0")
                    "url"("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    "distribution"("repo")
                }
            }
            "developers" {
                "developer" {
                    "name"("Alexander Weickmann")
                    "email"("alexander.weickmann@gmail.com")
                    "url"("https://github.com/weickmanna")
                    "organization"("link-time GmbH")
                    "organizationUrl"("https://link-time.com")
                }
            }
            "scm" {
                "url"("https://github.com/link-time/kotlin-wrappers/tree/master/${project.name}")
                "connection"("scm:git:git://github.com/link-time/kotlin-wrappers.git")
                "developerConnection"("scm:git:git://github.com/link-time/kotlin-wrappers.git")
            }
        }
    }
})

// disable archives set by nexus plugin, since we use Kotlin we have to create our own ones
configure<ExtraArchivePluginExtension> {
    sources = false
    tests = false
    javadoc = false
}

task("dokkaJavadoc", DokkaTask::class) {
    impliedPlatforms = mutableListOf("common")
    kotlinTasks {
        // dokka fails to retrieve sources from MPP-tasks so they must
        // be set empty to avoid exception - use sourceRoot instead (see below)
        listOf()
    }
    sourceRoot {
        path = "${project.name}/src/main/kotlin"
        platforms = listOf("common")
    }
    outputFormat = "javadoc"
    outputDirectory = "$buildDir/javadoc"
    reportUndocumented = false
}

task("javadocJar", Jar::class) {
    dependsOn("dokkaJavadoc")
    classifier = "javadoc"
    from("$buildDir/javadoc")
}

task("sourcesJar", Jar::class) {
    classifier = "sources"
    from("src/main/kotlin")
}

task("mavenPrepublish", Task::class) {
    dependsOn("install")
}

open class MavenCentralPublishingExtension {
    var name: String? = null
    var description: String? = null
}