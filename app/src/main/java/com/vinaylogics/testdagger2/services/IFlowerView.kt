package com.vinaylogics.testdagger2.services

import com.vinaylogics.testdagger2.model.Flower
import io.reactivex.Observable

/**
 * Created by Vinay on 1/17/2018.
 */
interface IFlowerView {
    fun flowers(flowers: List<Flower>)
    fun completed()
    fun error(message: String?)
    fun getFlowers(): Observable<List<Flower>>
}