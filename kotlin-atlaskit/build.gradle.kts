version = "0.1.0-SNAPSHOT"

plugins {
    `apply-kotlin-js`
    `apply-maven-central-publishing`
    `apply-npm-publishing`
}

dependencies {
    val reactVersion = property("react_version")
    implementation("org.jetbrains:kotlin-react:$reactVersion-pre.80-kotlin-1.3.41")
}

configure<Apply_maven_central_publishing_gradle.MavenCentralPublishingExtension> {
    name = "Kotlin Atlaskit"
    description = "Kotlin wrapper for Atlaskit by Atlassian."
}

task("prepublish", Task::class) {
    dependsOn("npmPrepublish", "mavenPrepublish")
}