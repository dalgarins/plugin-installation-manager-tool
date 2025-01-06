plugins {
    id("java")
}

group = "io.jenkins.plugin-management"
version = "1.0.2"

repositories {
    mavenCentral()
    maven("https://repo.jenkins-ci.org/public/")
}

dependencies {
    implementation("org.jenkins-ci:version-number:1.12")
    implementation("commons-io:commons-io:2.18.0")
    implementation("org.apache.commons:commons-lang3:3.17.0")
    implementation("commons-validator:commons-validator:1.9.0")
    implementation("org.apache.httpcomponents:httpclient:4.5.14")
    implementation("commons-codec:commons-codec:1.17.1")
    implementation("org.json:json:20241224")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.18.2")

    testImplementation("com.github.stefanbirkner:system-lambda:1.2.1")
    testImplementation("org.wiremock:wiremock:3.10.0") {
        exclude(group = "com.fasterxml.jackson.core", module = "jackson-annotations")
        exclude(group = "com.fasterxml.jackson.core", module = "jackson-databind")
    }
    testImplementation("com.github.stefanbirkner:system-rules:1.19.0")

    implementation("com.github.spotbugs:spotbugs-annotations:3.1.3")
}

tasks.test {
    useJUnitPlatform()
}