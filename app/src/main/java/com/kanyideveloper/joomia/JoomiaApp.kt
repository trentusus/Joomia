package com.kanyideveloper.joomia

import android.app.Application
import com.snowplowanalytics.snowplow.Snowplow
import com.snowplowanalytics.snowplow.configuration.NetworkConfiguration
import com.snowplowanalytics.snowplow.network.HttpMethod
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class JoomiaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        val networkConfig = NetworkConfiguration(
            "https://com-snplow-sales-gcp-prod1.mini.snplow.net",
            HttpMethod.POST
        )
        val tracker = Snowplow.createTracker(
            applicationContext, // Android context (LocalContext.current in Compose apps)
            "appId", // namespace
            networkConfig // Event collector URL
        );


    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}