plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.25.0")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.11.3")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.cucumber:cucumber-java:7.20.1")
    testImplementation("io.cucumber:cucumber-junit:7.20.1")
    testImplementation("io.cucumber:cucumber-picocontainer:7.20.1")
}

tasks.test {
    useJUnitPlatform()
}