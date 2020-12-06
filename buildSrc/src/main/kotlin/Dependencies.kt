const val kotlinVersion = "1.4.20"
const val hiltVersion = "2.28-alpha"

object BuildPlugins {
    private object Versions {
        const val buildToolsVersion = "4.2.0-beta01"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kapt = "kotlin-kapt"
    const val hilt = "dagger.hilt.android.plugin"
}

object AndroidSdk {
    const val min = 21
    const val compile = 30
    const val target = compile
    const val jvmTarget = "1.11"
}

// Libraries
object Libraries {
    private object Versions {
        // Android X
        const val appCompat = "1.2.0"
        const val room = "2.2.5"
        const val navigation = "2.3.2"

        // AndroidX ktx
        const val ktx = "1.3.2"

        // Material
        const val material = "1.2.1"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val kaptRoom = "androidx.room:room-compiler:${Versions.room}"

    const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
    const val kaptHilt = "com.google.dagger:hilt-android-compiler:$hiltVersion"
}


// Testing
object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.1.2"
        const val espresso = "3.3.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
