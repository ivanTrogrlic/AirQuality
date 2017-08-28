package com.ivantrogrlic.airquality.web

import com.ivantrogrlic.airquality.model.Metadata
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ivan on 8/23/2017.
 */

interface OpenAqWebService {

    @GET("locations")
    fun locations(@Query("coordinates") coordinates: String,
                  @Query("limit") limit: Int,
                  @Query("radius") radius: Int): Single<Metadata>

}
