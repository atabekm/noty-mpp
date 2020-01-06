object Android {
    const val build_tools_version = "29.0.2"
    const val compile_sdk_version = 29
    const val min_sdk_version = 21
    const val target_sdk_version = 29
    const val version_code = 1
    const val version_name = "0.1"
}

object Modules {
    const val shared = ":shared"
}

object Versions {
    const val androidx = "1.1.0"
    const val constraintlayout = "1.1.3"
    const val kotlin = "1.3.61"
    const val kotlinx_serialization = "0.13.0"
    const val material = "1.0.0"
    const val recycler = "1.1.0"
    const val sqldelight = "1.2.1"
}

object Libs {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.androidx}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val kotlin_std = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlin_std_common = "org.jetbrains.kotlin:kotlin-stdlib-common:${Versions.kotlin}"
    const val kotlin_std_jdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val ktx = "androidx.core:core-ktx:${Versions.androidx}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val recycler = "androidx.recyclerview:recyclerview:${Versions.recycler}"
    const val serialization_runtime = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.kotlinx_serialization}"
    const val serialization_runtime_common = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:${Versions.kotlinx_serialization}"
    const val sqldelight_android = "com.squareup.sqldelight:android-driver:${Versions.sqldelight}"
    const val sqldelight_ios = "com.squareup.sqldelight:ios-driver:${Versions.sqldelight}"
    const val sqldelight_runtime = "com.squareup.sqldelight:runtime:${Versions.sqldelight}"
}
