package com.ivantrogrlic.airquality

import android.app.Application
import com.ivantrogrlic.airquality.dagger.AppComponent
import com.ivantrogrlic.airquality.dagger.DaggerAppComponent
import dagger.android.HasActivityInjector
import android.app.Activity
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

/**
 * Created by ivan on 8/23/2017.
 */

class OpenAqApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build()
        appComponent.inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    fun component() = appComponent

}