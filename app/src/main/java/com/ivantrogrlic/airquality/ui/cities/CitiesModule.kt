package com.ivantrogrlic.airquality.ui.cities

import dagger.Module
import dagger.Provides

/**
 * Created by ivan on 8/23/2017.
 */

@Module
class CitiesModule {

    @Provides
    fun provideDetailFragmentView(citiesFragment: CitiesFragment): CitiesView = citiesFragment

}
