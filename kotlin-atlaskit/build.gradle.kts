val reactVersion = property("react_version")

version = "0.1.0-SNAPSHOT"

applyKotlinJs(
        dependencies = listOf(
                "org.jetbrains:kotlin-react:$reactVersion-pre.80-kotlin-1.3.41"
        )
)
applyMavenCentralPublish(
        name = "Kotlin Atlaskit",
        description = "Kotlin wrapper for Atlaskit by Atlassian.")
applyNpmPublish()
