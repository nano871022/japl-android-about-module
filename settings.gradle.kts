pluginManagement {
    repositories {
        google()
        maven { url = java.net.URI("https://maven.aliyun.com/repository/public") }
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.library") version "9.3.1"
        id("org.jetbrains.kotlin.plugin.compose") version "2.4.10"
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        maven { url = java.net.URI("https://maven.aliyun.com/repository/public") }
        mavenCentral()
    }
}

rootProject.name = "japl-android-about-module"
