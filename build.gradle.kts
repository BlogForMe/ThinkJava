import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    java
    `maven-publish`
    kotlin("jvm") version "1.5.30"
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
    google()
    mavenLocal()
}

dependencies {
    implementation("com.io7m.xom:xom:1.2.10")
    implementation("junit:junit:4.13.2")
//    testImplementation("org.junit.platform:junit-platform-launcher:1.7.2")
//    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")
//    testImplementation("org.junit.vintage:junit-vintage-engine:5.7.2")
    implementation(kotlin("stdlib-jdk8"))
}

group = "ThinkJava"
version = "1.0-SNAPSHOT"
description = "ThinkJava"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}