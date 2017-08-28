package com.ivantrogrlic.airquality.model

import java.util.*

/**
 * Created by ivan on 8/23/2017.
 */

data class Location(val location: String,
                    val country: String,
                    val city: String,
                    val sourceName: String,
                    val lastUpdated: Date)
