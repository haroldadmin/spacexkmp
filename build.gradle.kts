plugins {
    kotlin("multiplatform") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.10"
    id("com.diffplug.spotless") version "5.13.0"
}

group = "com.haroldadmin"
version = "0.0.1"

repositories {
    mavenCentral()
}

val ktorVersion = "1.6.0"

kotlin {
    explicitApi()

    // Enable JVM target support
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }

    // Enable Native target support
    val hostOs = System.getProperty("os.name")
    when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        hostOs.startsWith("Windows") -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("io.ktor:ktor-client-core:$ktorVersion")
                api("io.ktor:ktor-client-cio:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("io.ktor:ktor-client-mock:$ktorVersion")
                implementation("ch.qos.logback:logback-classic:1.2.3")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val nativeMain by getting
        val nativeTest by getting
    }
}

spotless {
    kotlin {
        ktlint()
    }
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
    }
}
