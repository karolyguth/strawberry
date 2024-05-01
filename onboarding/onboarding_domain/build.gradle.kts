plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.karolyguth.onboarding_domain"
}

dependencies {
    implementation(project(Modules.core))
}