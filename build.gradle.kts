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
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.mockito:mockito-core:5.11.0")
    implementation(project(":Application"))
    implementation(project(":DataAccess"))
    implementation(project(":presentation"))
    implementation ("org.springframework.boot:spring-boot-starter")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    implementation ("org.springframework.boot:spring-boot-starter-data-rest")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("javax.persistence:javax.persistence-api:2.2")
}

tasks.test {
    useJUnitPlatform()
}