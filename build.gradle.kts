plugins {
    scala
    application
    alias(libs.plugins.spotless)
}

repositories { mavenCentral() }

dependencies {
    compileOnly(libs.bundles.scalafmt)
    implementation(libs.scala)
    testImplementation(libs.scalatest)
    testImplementation(libs.scalatestplusjunit)
}

application {
    mainClass.set("main.MainClass")
}

// Code Style and Licensing
spotless {
    isEnforceCheck = false
    scala {
        scalafmt(libs.versions.scalafmt.version.get()).configFile(".scalafmt.conf")
        // add for applying a license to each source file: licenseHeaderFile(file("../LICENSE-HEADER"), "package ")
    }
    // always apply formatting before building, running or testing the project
    tasks.compileScala.get().dependsOn(tasks.spotlessApply)
}