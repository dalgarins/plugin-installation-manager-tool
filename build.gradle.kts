plugins {
    id("java")
    `maven-publish`
}

group = "io.jenkins.plugin-management"
version = "1.0.2"

repositories {
    mavenCentral()
    maven("https://repo.jenkins-ci.org/public/")
}

dependencies {
    implementation("org.jenkins-ci:version-number:1.12")
    implementation("org.apache.commons:commons-lang3:3.17.0")
    implementation("commons-io:commons-io:2.18.0")
    implementation("args4j:args4j:2.37")
    implementation("com.github.spotbugs:spotbugs-annotations:3.1.3")
    testImplementation("com.github.stefanbirkner:system-lambda:1.2.1")
    testImplementation("org.assertj:assertj-core")
    implementation("org.assertj:assertj-core:3.27.2")

    // Resolve new checks added by enforcer plugin in parent pom 1.95
    implementation("net.bytebuddy:byte-buddy:1.15.11")
    implementation(project(":plugin-management-library"))
}

tasks.test {
    useJUnitPlatform()
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "maven-publish")

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "io.jenkins.plugin-management"
                artifactId = "plugin-management"
                version = "1.0.2"

                from(components["java"])
            }
        }
    }
}