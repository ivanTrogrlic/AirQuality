package com.ivantrogrlic.airquality.ui.home

import android.content.Context
import com.airquallity.ivan.persistentsearch.SearchResult
import com.ivantrogrlic.airquality.dagger.ApplicationContext
import com.ivantrogrlic.airquality.model.Location
import com.ivantrogrlic.airquality.model.Metadata
import com.ivantrogrlic.airquality.web.OpenAqWebService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.requery.Persistable
import io.requery.kotlin.eq
import io.requery.reactivex.KotlinReactiveEntityStore
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by ivan on 8/28/2017.
 */

class HomePresenter @Inject
constructor(@ApplicationContext private val context: Context,
            private val homeView: HomeView,
            private val openAqWebService: OpenAqWebService,
            private val data: KotlinReactiveEntityStore<Persistable>) {

    private val locations: MutableMap<String, Location> = mutableMapOf()

    fun findCities(cityName: String) {
//        Single.defer { Single.just(Geocoder(context).getFromLocationName(cityName, 1)) }
//                .map { it.first() }
//                .map { it.latitude.toString() + "," + it.longitude }
//                .flatMap { openAqWebService.locations(it, 10, 2500) }
        openAqWebService.locations("51.50,-0.11", 10, 5000)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ handleLocationsReceived(it) },
                        { Timber.e(it, "Failed loading cities") })
    }

    fun saveSelectedCity(searchResult: SearchResult) {
        val location = (data select (Location::class)
                where (Location::location.eq(searchResult.title.substringBefore(","))))
                .get()

        if (location.any()) TODO("Location already exist")
        data.insert(locations[searchResult.title] as Location)
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    private fun handleLocationsReceived(it: Metadata) {
        locations.clear()
        it.locations.forEach {
            val displayName = it.location + ", " + it.city + ", " + it.country
            locations.plusAssign(Pair(displayName, it))
        }

        homeView.citiesFound(locations.keys.toList())
    }

}
