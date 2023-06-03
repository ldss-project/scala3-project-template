plugins {
    scala
    application
}

repositories { mavenCentral() }

dependencies {
    implementation(libs.scala)
    testImplementation(libs.scalatest)
    testImplementation(libs.scalatestplusjunit)
}

application {
    mainClass.set("main.MainClass")
}