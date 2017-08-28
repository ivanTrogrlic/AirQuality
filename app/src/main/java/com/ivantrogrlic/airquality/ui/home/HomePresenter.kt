package com.ivantrogrlic.airquality.ui.home

import android.content.Context
import com.ivantrogrlic.airquality.dagger.ApplicationContext
import com.ivantrogrlic.airquality.web.OpenAqWebService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by ivan on 8/28/2017.
 */

class HomePresenter @Inject
constructor(@ApplicationContext private val context: Context,
            private val homeView: HomeView,
            private val openAqWebService: OpenAqWebService) {

    fun findCities(cityName: String) {
//        Single.defer { Single.just(Geocoder(context).getFromLocationName(cityName, 1)) }
//                .map { it.first() }
//                .map { it.latitude.toString() + "," + it.longitude }
//                .flatMap { openAqWebService.locations(it, 10, 2500) }
        openAqWebService.locations("51.50,-0.11", 10, 5000)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ homeView.citiesFound(it.locations) },
                        { Timber.e(it, "Failed loading cities") })
    }

}