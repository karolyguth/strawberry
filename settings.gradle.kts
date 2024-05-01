pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //To fix the error:Could not resolve all files for configuration ':app:debugAndroidTestRuntimeClasspath'.
        //   > Could not find com.linkedin.dexmaker:dexmaker:2.21.0.
        jcenter()
    }
}

rootProject.name = "Strawberry"
include(":app")
include(":core")
include(":onboarding")
include(":onboarding:onboarding_presentation")
include(":onboarding:onboarding_domain")
include(":tracker")
include(":tracker:tracker_data")
include(":tracker:tracker_domain")
include(":tracker:tracker_presentation")
include(":core_ui")
//TO FIX ERROR
gradle.startParameter.excludedTaskNames.addAll(listOf(":buildSrc:testClasses"))