package com.ivantrogrlic.airquality.dagger

import com.ivantrogrlic.airquality.ui.home.HomeActivity
import com.ivantrogrlic.airquality.ui.home.HomeModule
import com.ivantrogrlic.airquality.ui.cities.CitiesFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by ivan on 8/23/2017.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(HomeModule::class, CitiesFragmentProvider::class))
    internal abstract fun bindHomeActivity(): HomeActivity

}
