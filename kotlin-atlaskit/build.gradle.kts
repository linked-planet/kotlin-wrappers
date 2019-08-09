version = "0.1.0-SNAPSHOT"

plugins {
    `apply-kotlin-js`
}

dependencies {
    val reactVersion = property("react_version")
    implementation("org.jetbrains:kotlin-react:$reactVersion-pre.80-kotlin-1.3.41")
}

applyAllPublishing(
        name = "Kotlin Atlaskit",
        description = "Kotlin wrapper for Atlaskit by Atlassian."
)
