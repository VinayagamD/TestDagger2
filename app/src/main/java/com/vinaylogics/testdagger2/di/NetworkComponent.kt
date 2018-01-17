package com.vinaylogics.testdagger2.di

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Vinay on 1/17/2018.
 */
@Component(modules = [(NetworkModule::class)])
@Singleton
interface NetworkComponent {
    fun retrofit():Retrofit
}