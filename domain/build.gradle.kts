plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    //Coroutines
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)

    //Hilt
    implementation (libs.hilt.core)

    //Gson
    implementation (libs.converter.gson)
    implementation (libs.json)

    // Testing
    testImplementation (libs.junit)
    testImplementation (libs.mockito.core)
    testImplementation (libs.mockito.kotlin)
    testImplementation (libs.mockito.inline)
    implementation (libs.kotlin.stdlib)
    testImplementation (libs.turbine)
    testImplementation (libs.kotlinx.coroutines.test)

    testImplementation(libs.junit)
}
