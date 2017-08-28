package com.ivantrogrlic.airquality.ui.cities

import android.content.Context
import com.ivantrogrlic.airquality.dagger.ApplicationContext
import com.ivantrogrlic.airquality.web.OpenAqWebService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by ivan on 8/23/2017.
 */

class CitiesPresenter @Inject
constructor(@ApplicationContext private val context: Context,
            private val citiesView: CitiesView,
            private val openAqWebService: OpenAqWebService) {


}
