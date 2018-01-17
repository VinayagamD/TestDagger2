package com.vinaylogics.testdagger2.core

import android.app.Application
import com.vinaylogics.testdagger2.di.DaggerApiComponent
import com.vinaylogics.testdagger2.di.DaggerNetworkComponent
import com.vinaylogics.testdagger2.di.NetworkComponent
import com.vinaylogics.testdagger2.di.NetworkModule
import com.vinaylogics.testdagger2.utils.Constant

/**
 * Created by Vinay on 1/17/2018.
 */
class FlowerApplication : Application(){

    override fun onCreate() {
        resolveDependency()
        super.onCreate()
    }
    lateinit var component: DaggerApiComponent
    private fun resolveDependency() {
         component = DaggerApiComponent.builder()
                 .networkComponent(getNetworkComponent())
                 .build() as DaggerApiComponent
    }

    private fun getNetworkComponent(): NetworkComponent? {
        return DaggerNetworkComponent.
                builder()
                .networkModule(NetworkModule())
                .build()
    }
}