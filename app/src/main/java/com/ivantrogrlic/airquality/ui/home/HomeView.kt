package com.ivantrogrlic.airquality.ui.home

import com.ivantrogrlic.airquality.model.Location

/**
 * Created by ivan on 8/28/2017.
 */

interface HomeView {
    fun citiesFound(locations: List<Location>)
}
