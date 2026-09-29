pluginManagement {
    repositories {
        google()
        maven { url = java.net.URI("https://maven.aliyun.com/repository/public") }
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.library") version "8.6.1"
        id("org.jetbrains.kotlin.android") version "2.0.21"
        id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
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
