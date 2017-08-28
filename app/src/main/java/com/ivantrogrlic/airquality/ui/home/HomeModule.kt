package com.ivantrogrlic.airquality.ui.home

import android.content.Context
import com.ivantrogrlic.airquality.dagger.ActivityContext
import com.ivantrogrlic.airquality.ui.cities.CitiesFragment
import com.ivantrogrlic.airquality.ui.cities.CitiesView
import com.ivantrogrlic.airquality.ui.home.HomeActivity
import dagger.Module
import dagger.Provides

/**
 * Created by ivan on 8/23/2017.
 */

@Module
class HomeModule {

    @Provides
    @ActivityContext
    fun provideActivityContext(detailActivity: HomeActivity): Context = detailActivity

    @Provides
    fun provideHomeView(homeActivity: HomeActivity): HomeView = homeActivity

}
