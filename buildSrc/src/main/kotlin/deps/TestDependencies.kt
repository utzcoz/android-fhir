package deps

object TestDependencies {

  object CoreTestDeps {
    const val core = "androidx.test:core:${versions.TestDependencies.CoreTest.core}"
    const val ext_junit = "androidx.test.ext:junit:${versions.TestDependencies.CoreTest.junit}"
    const val ext_junit_ktx =
      "androidx.test.ext:junit-ktx:${versions.TestDependencies.CoreTest.junit}"
    const val rules = "androidx.test:rules:${versions.TestDependencies.CoreTest.rules}"
    const val runner = "androidx.test:runner:${versions.TestDependencies.CoreTest.runner}"
  }

  const val truth = "com.google.truth:truth:${versions.TestDependencies.truth}"

  object Espresso {
    const val espresso =
      "androidx.test.espresso:espresso-core:${versions.TestDependencies.Espresso.espresso}"
  }
  const val roboelectric = "org.robolectric:robolectric:${versions.TestDependencies.Espresso.roboelectric}"
  const val standardRunner = "androidx.test.runner.AndroidJUnitRunner"
}
