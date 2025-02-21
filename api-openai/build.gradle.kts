plugins {
    id("java")
    id("maven-publish")
}

group = "org.rangenx"
version = "0.0.1-beta"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation(project(":rangenx-framework"))
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = "org.rangenx"
            artifactId = "api-openai"
            version = "0.0.1-beta"
        }
    }

    repositories {
        mavenLocal()
    }
}