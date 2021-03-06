import java.nio.file.Paths

plugins {
    id("application")
}

application {
    mainClass.set("com.minestom.data_generator.DataGenerator")
}

dependencies {
    val jarsDirectory = Paths.get(System.getenv("DATA_GEN_OUT_JARS")
        ?: "${project.projectDir.absolutePath}../../Deobfuscator/deobfuscated_jars/")
    val version: String = (project.properties["mcversion"] ?: "1.16.5") as String
    implementation(files(jarsDirectory.resolve("deobfu_$version.jar")))
}
