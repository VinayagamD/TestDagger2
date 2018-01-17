package com.vinaylogics.testdagger2.base

/**
 * Created by Vinay on 1/17/2018.
 */
interface Presenter {
    fun onCreate()
    fun onPause()
    fun onResume()
    fun onDestroy()
}