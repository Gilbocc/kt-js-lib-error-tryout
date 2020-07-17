plugins {
    kotlin("multiplatform") version "1.3.72"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("it.unibo.tuprolog:parser-theory:0.11.1")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        jvm {

            compilations["main"].defaultSourceSet {
                dependencies {
                    implementation(kotlin("stdlib-jdk8"))
                }
            }

            compilations["test"].defaultSourceSet {
                dependencies {
                    implementation(kotlin("test-junit"))
                }
            }
        }

        js {
            nodejs()

            compilations["main"].defaultSourceSet {
                dependencies {
                    implementation(kotlin("stdlib-js"))
                }
            }

            compilations["test"].defaultSourceSet {
                dependencies {
                    implementation(kotlin("test-js"))
                }
            }
        }
    }
}