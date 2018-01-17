package com.vinaylogics.testdagger2.di

import com.vinaylogics.testdagger2.MainActivity
import dagger.Component

/**
 * Created by Vinay on 1/17/2018.
 */
@Component(modules = [ApiModule::class], dependencies = [NetworkComponent::class])
@CustomScope
interface ApiComponent {
    fun inject(activity: MainActivity)
}