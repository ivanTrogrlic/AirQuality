package com.ivantrogrlic.airquality.model

import io.requery.Entity
import io.requery.Persistable
import java.util.*

/**
 * Created by ivan on 8/23/2017.
 */

@Entity
data class Location constructor(
        val location: String,
        val country: String,
        val city: String,
        val sourceName: String,
        val lastUpdated: Date
) : Persistable
