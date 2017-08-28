package com.ivantrogrlic.airquality.ui.cities

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ivantrogrlic.airquality.R
import com.ivantrogrlic.airquality.model.Location
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by ivan on 8/23/2017.
 */

class CitiesFragment : Fragment(), CitiesView {

    @Inject
    lateinit var citiesPresenter: CitiesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.cities_fragment, container, false)

    override fun citiesFound(locations: List<Location>) {
        Timber.d("TROGY: $locations")
    }

}
