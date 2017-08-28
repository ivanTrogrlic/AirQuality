package com.ivantrogrlic.airquality.ui.cities

import com.ivantrogrlic.airquality.model.Location

/**
 * Created by ivan on 8/23/2017.
 */

interface CitiesView {
    fun citiesFound(locations: List<Location>)
}
