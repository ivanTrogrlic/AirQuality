package com.ivantrogrlic.airquality.dagger

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.ivantrogrlic.airquality.OpenAqApplication
import com.ivantrogrlic.airquality.web.NetModule
import com.ivantrogrlic.airquality.web.OpenAqWebService
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import io.requery.Persistable
import io.requery.reactivex.KotlinReactiveEntityStore
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * Created by ivan on 8/23/2017.
 */

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, ActivityBuilder::class, AppModule::class, NetModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: OpenAqApplication)

    @ApplicationContext
    fun context(): Context

    fun sharedPreferences(): SharedPreferences
    fun retrofit(): Retrofit
    fun okHttp(): OkHttpClient
    fun openWebService(): OpenAqWebService

    fun kotlinReactiveEntityStore(): KotlinReactiveEntityStore<Persistable>

}
