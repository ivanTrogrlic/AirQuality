package com.ivantrogrlic.airquality.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ivan on 8/24/2017.
 */

data class Metadata(@SerializedName("results") val locations: List<Location>)
