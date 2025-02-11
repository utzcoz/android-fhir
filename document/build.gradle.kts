plugins {
  id(Plugins.BuildPlugins.androidLib)
  id(Plugins.BuildPlugins.kotlinAndroid)
}

android {
  namespace = "com.google.android.fhir.document"
  compileSdk = Sdk.COMPILE_SDK

  defaultConfig {
    minSdk = Sdk.MIN_SDK
    testInstrumentationRunner = Dependencies.androidJunitRunner
    consumerProguardFiles("consumer-rules.pro")
  }

  compileOptions {
    // Flag to enable support for the new language APIs
    // See https = //developer.android.com/studio/write/java8-support
    isCoreLibraryDesugaringEnabled = true
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  packaging { resources.excludes.addAll(listOf("META-INF/ASL-2.0.txt", "META-INF/LGPL-3.0.txt")) }

  sourceSets { getByName("test").apply { resources.setSrcDirs(listOf("test-data")) } }

  kotlin { jvmToolchain(11) }
}

dependencies {
  androidTestImplementation(libs.androidx.test.espresso.core)
  androidTestImplementation(libs.androidx.test.ext.junit)

  coreLibraryDesugaring(Dependencies.desugarJdkLibs)

  implementation(Dependencies.material)
  implementation(Dependencies.Retrofit.coreRetrofit)
  implementation(Dependencies.Retrofit.gsonConverter)
  implementation(Dependencies.httpInterceptor)
  implementation(Dependencies.zxing)
  implementation(Dependencies.nimbus)
  implementation(Dependencies.timber)
  implementation(libs.android.fhir.engine)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.core)

  testImplementation(Dependencies.robolectric)
  testImplementation(Dependencies.mockitoKotlin)
  testImplementation(Dependencies.mockitoInline)
  testImplementation(Dependencies.mockWebServer)
  testImplementation(libs.junit)
  testImplementation(libs.kotlinx.coroutines.test)
  testImplementation(libs.truth)
}
