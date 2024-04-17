plugins {
    id("java")
    id("org.hibernate.orm") version "6.4.4.Final"
    kotlin("plugin.lombok") version "1.9.22"
    id("io.freefair.lombok") version "8.1.0"
    id ("org.springframework.boot") version "3.2.3"
    id ("io.spring.dependency-management") version "1.1.4"
}

group = "aze.Abbasov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("org.postgresql:postgresql:42.7.2")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.flywaydb:flyway-core:10.9.1")
    implementation(project(":Application"))
    implementation ("org.springframework.boot:spring-boot-starter")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    implementation ("org.springframework.boot:spring-boot-starter-data-rest")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.test {
    useJUnitPlatform()
}