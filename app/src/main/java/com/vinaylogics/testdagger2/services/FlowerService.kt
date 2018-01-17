package com.vinaylogics.testdagger2.services

import com.vinaylogics.testdagger2.model.Flower
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Vinay on 1/17/2018.
 */
interface FlowerService {
    @GET("feeds/flowers.json")
    fun getFlowers() : Observable<List<Flower>>
}