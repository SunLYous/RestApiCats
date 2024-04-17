plugins {
    id("java")
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
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":Application"))
    implementation ("org.springframework.boot:spring-boot-starter")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    implementation ("org.springframework.boot:spring-boot-starter-data-rest")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.test {
    useJUnitPlatform()
}