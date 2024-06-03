group = 'com.project'
version = '1.0-SNAPSHOT'

description = 'Automatización'

apply plugin: 'java'
apply plugin: 'java-library'
apply plugin: 'maven-publish'
apply plugin: 'net.serenity-bdd.serenity-gradle-plugin'

compileJava.options.encoding = "UTF-8"
compileTestJava.options.encoding = "UTF-8"

def versionSerenity = '4.0.40'
def versionCucumber = '7.12.1'

repositories {
    mavenCentral()
}
buildscript {
    repositories {
        mavenCentral()
    }

}
buildscript {
    repositories {
        maven {
            url "https://plugins.gradle.org/m2/"
        }
    }
    dependencies {
        classpath "net.serenity-bdd:serenity-gradle-plugin:4.0.19"

    }
}
dependencies {
    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    implementation "net.serenity-bdd:serenity-cucumber:${versionSerenity}"
    implementation group: 'io.cucumber', name: 'datatable', version: "${versionCucumber}"
    implementation group: 'io.cucumber', name: 'cucumber-junit', version: "${versionCucumber}"
    implementation group: 'net.serenity-bdd', name: 'serenity-screenplay', version: "${versionSerenity}"
    implementation group: 'net.serenity-bdd', name: 'serenity-screenplay-webdriver', version: "${versionSerenity}"
    implementation group: 'net.serenity-bdd', name: 'serenity-junit', version: "${versionSerenity}"
    implementation group: 'net.serenity-bdd', name: 'serenity-core', version: "${versionSerenity}"
    implementation group: 'net.serenity-bdd', name: 'serenity-report-resources', version: "${versionSerenity}"
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.16.1'
}
serenity{
    testRoot="com.project.runners"
    requirementsBaseDir="src/test/resources/features/agregarproducto.feature"
    reports= ["single-page-html"]

}
test {
    useJUnitPlatform()
    useJUnit {
        include "**/*";
        gradle.startParameter.continueOnFailure = true
        testLogging.showStandardStreams = true
        systemProperties System.getProperties()
        systemProperty "cucumber.filter.tags", System.getProperty("cucumber.filter.tags")
    }
}

