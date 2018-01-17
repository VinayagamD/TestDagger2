package com.vinaylogics.testdagger2.di

import android.support.annotation.Nullable
import com.vinaylogics.testdagger2.utils.Constant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Vinay on 1/17/2018.
 */
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Module
class NetworkModule(val baseUrl: String? = Constant.BASE_URL ) {

    @Provides
    @Singleton
    fun provideGsonConverterFactory():GsonConverterFactory=GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRxJMava2CallAdapterFactory():RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory, callAdapterFactory: RxJava2CallAdapterFactory):Retrofit = Retrofit.Builder()
                                    .baseUrl(baseUrl)
                                    .addConverterFactory(gsonConverterFactory)
                                    .addCallAdapterFactory(callAdapterFactory)
                                    .build()
}