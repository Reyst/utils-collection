plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("maven-publish")
}

android {
    namespace = "com.github.reyst.utils"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        lint.targetSdk = 35
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (
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
        jvmTarget = "1.8"
    }
    publishing {
        publishing {
            singleVariant("release") {
                withSourcesJar()
            }
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
//        release(MavenPublication) {
            groupId = "com.github.Reyst"
            artifactId = "utils-collection"
            version = "1.0.7"

            afterEvaluate {
                from (components["release"])
            }
        }
    }
}

dependencies {
    implementation ("androidx.appcompat:appcompat:1.7.0")
}
