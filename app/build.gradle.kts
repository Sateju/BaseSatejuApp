plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
    id(Plugins.hilt)
    id(Plugins.navigationSafeargs)
}

android {
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
        applicationId = "jjtelechea.example.basesatejuapp"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AndroidSdk.jvmTarget
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.coroutines)
    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
    implementation(Libraries.recycler)
    implementation(Libraries.material)
    implementation(Libraries.navigation)
    implementation(Libraries.navigationUi)

    // DataBinding
    kapt(Libraries.kaptDataBinding)

    // Lifecycle
    implementation(Libraries.viewModel)
    implementation(Libraries.liveData)
    kapt(Libraries.kaptLifeCycle)

    // Room
    implementation(Libraries.room)
    kapt(Libraries.kaptRoom)
    implementation(Libraries.roomExtensions)

    // Hilt
    implementation(Libraries.hilt)
    implementation(Libraries.hiltViewModel)
    kapt(Libraries.kaptHilt)
    kapt(Libraries.kaptHiltViewModel)

    // Retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitConverter)
    implementation(Libraries.okhttp)
    implementation(Libraries.okhttpInterceptor)

    // Testing
    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}