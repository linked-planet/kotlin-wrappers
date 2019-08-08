val reactVersion = property("react_version")

version = "0.1.0-SNAPSHOT"

apply<ApplyKotlinJs>()
apply<ConfigureNpmPublish>()

plugins {
    id("kotlin2js")
}

dependencies {
    implementation(group = "org.jetbrains", name = "kotlin-react", version = "$reactVersion-pre.80-kotlin-1.3.41")
}
