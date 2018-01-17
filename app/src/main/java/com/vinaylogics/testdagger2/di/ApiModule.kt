package com.vinaylogics.testdagger2.di

import com.vinaylogics.testdagger2.services.FlowerService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Vinay on 1/17/2018.
 */
@Module
class ApiModule {
    @Provides
    @CustomScope
    fun provideFlowerService(retrofit: Retrofit) = retrofit.create(FlowerService::class.java)

}