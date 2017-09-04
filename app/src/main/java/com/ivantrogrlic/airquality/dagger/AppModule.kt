package com.ivantrogrlic.airquality.dagger

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.ivantrogrlic.airquality.model.Models
import dagger.Module
import dagger.Provides
import io.requery.Persistable
import io.requery.android.sqlite.DatabaseSource
import io.requery.reactivex.KotlinReactiveEntityStore
import io.requery.sql.KotlinEntityDataStore
import io.requery.sql.TableCreationMode
import javax.inject.Singleton

/**
 * Created by ivan on 8/23/2017.
 */

@Module
class AppModule {

    @Provides
    @ApplicationContext
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun sharedPreferencesName(): String = "AirQualityPrefs"

    @Provides
    @Singleton
    fun sharedPreferences(@ApplicationContext context: Context,
                          sharedPreferencesName: String): SharedPreferences =
            context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun kotlinReactiveEntityStore(@ApplicationContext context: Context): KotlinReactiveEntityStore<Persistable> {
        val source = DatabaseSource(context, Models.DEFAULT, 1)
        source.setTableCreationMode(TableCreationMode.DROP_CREATE)
        return KotlinReactiveEntityStore(KotlinEntityDataStore(source.configuration))
    }

}
