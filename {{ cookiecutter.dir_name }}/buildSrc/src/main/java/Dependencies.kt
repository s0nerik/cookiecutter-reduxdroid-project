object Versions {
    val min_sdk = 21
    val compile_sdk = 28
    val target_sdk = compile_sdk

    val kotlin = "1.3.0-rc-146"
    val kotlin_coroutines = "0.30.0-eap13"
    val kotlin_serialization = "0.8.0-rc13"
}

object Libs {
    //region Kotlin
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    val kotlin_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlin_coroutines}"
    val kotlin_serialization = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.kotlin_serialization}"

    val kotlin = arrayOf(kotlin_stdlib, kotlin_reflect, kotlin_coroutines, kotlin_serialization)
    //endregion

    //region Koin
    private val koinVersion = "1.0.1"

    val koin_core = "org.koin:koin-core:$koinVersion"
    val koin_android = "org.koin:koin-android:$koinVersion"
    val koin_androidx_scope = "org.koin:koin-androidx-scope:$koinVersion"
    val koin_androidx_viewmodel = "org.koin:koin-androidx-viewmodel:$koinVersion"

    val koin = arrayOf(koin_core, koin_android, koin_androidx_scope, koin_androidx_viewmodel)
    //endregion

    //region Reduxdroid
    private val reduxdroidVersion = "740fb2e53d"

    val reduxdroid_core = "com.github.s0nerik.reduxdroid:core:$reduxdroidVersion"
    val reduxdroid_activity_result = "com.github.s0nerik.reduxdroid:activity_result:$reduxdroidVersion"
    val reduxdroid_state_serializer = "com.github.s0nerik.reduxdroid:state_serializer:$reduxdroidVersion"
    val reduxdroid_navigation = "com.github.s0nerik.reduxdroid:navigation:$reduxdroidVersion"
    val reduxdroid_livedata = "com.github.s0nerik.reduxdroid:livedata:$reduxdroidVersion"
    val reduxdroid_viewmodel = "com.github.s0nerik.reduxdroid:viewmodel:$reduxdroidVersion"

    val reduxdroid = arrayOf(
            reduxdroid_core,
            reduxdroid_activity_result,
            reduxdroid_state_serializer,
            reduxdroid_navigation,
            reduxdroid_livedata,
            reduxdroid_viewmodel
    )
    //endregion

    //region AndroidX
    private val androidxVersion = "1.0.0"
    private val androidxNavVersion = "1.0.0-alpha06"

    val androidx_core = "androidx.core:core:$androidxVersion"
    val androidx_core_ktx = "androidx.core:core-ktx:$androidxVersion"

    val androidx_material = "com.google.android.material:material:$androidxVersion"
    val androidx_appcompat = "androidx.appcompat:appcompat:$androidxVersion"
    val androidx_recyclerview = "androidx.recyclerview:recyclerview:$androidxVersion"
    val androidx_constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"

    val androidx_nav_runtime = "android.arch.navigation:navigation-runtime:$androidxNavVersion"
    val androidx_nav_ui_ktx = "android.arch.navigation:navigation-ui-ktx:$androidxNavVersion"
    val androidx_nav_fragment_ktx = "android.arch.navigation:navigation-fragment-ktx:$androidxNavVersion"

    val livedata_ktx = "com.shopify:livedata-ktx:2.0.1"

    val bindingCollectionAdapter = arrayOf(
            "com.github.evant.binding-collection-adapter:bindingcollectionadapter:master-SNAPSHOT",
            "com.github.evant.binding-collection-adapter:bindingcollectionadapter-recyclerview:master-SNAPSHOT"
    )

    val androidx = arrayOf(
            androidx_core, androidx_core_ktx,
            androidx_material, androidx_appcompat, androidx_recyclerview, androidx_constraintlayout,
            livedata_ktx,
            androidx_nav_runtime, androidx_nav_ui_ktx, androidx_nav_fragment_ktx,
            *bindingCollectionAdapter
    )
    //endregion

    //region Testing
    val junit = "junit:junit:4.12"
    val supportRunner = "com.android.support.test:runner:1.0.2"
    val supportEspresso = "com.android.support.test.espresso:espresso-core:3.0.2"

    val unitTest = arrayOf(junit)
    val androidTest = arrayOf(supportRunner, supportEspresso)
    //endregion

    //region Sets
    val module_basic = arrayOf(
            *kotlin, koin_core, reduxdroid_core
    )
    val module_ui = arrayOf(
            *kotlin, *koin, *reduxdroid, *androidx, *bindingCollectionAdapter
    )
    //endregion
}