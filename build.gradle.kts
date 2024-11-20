plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.10.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.18.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.18.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.1")
    implementation("org.hibernate.validator:hibernate-validator:6.2.5.Final")
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("org.glassfish:javax.el:3.0.0")
    implementation("org.postgresql:postgresql:42.7.4")
    implementation("org.slf4j:slf4j-api:1.7.36")
}

tasks.test {
    useTestNG()
}