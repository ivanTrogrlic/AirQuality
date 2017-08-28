package com.ivantrogrlic.airquality.ui.cities

import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by ivan on 8/23/2017.
 */

@Module
abstract class CitiesFragmentProvider {

    @ContributesAndroidInjector(modules = arrayOf(CitiesModule::class))
    abstract fun provideCitiesFragmentFactory(): CitiesFragment
}
