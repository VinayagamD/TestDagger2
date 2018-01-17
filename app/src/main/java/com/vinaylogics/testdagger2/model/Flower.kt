package com.vinaylogics.testdagger2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Vinay on 1/17/2018.
 */
data class Flower(
        @SerializedName("categroy")
        @Expose
        var category: String? = "",
        @SerializedName("instructions")
        @Expose
        var instructions : String? = "",
        @SerializedName("photo")
        @Expose
        var photo : String? = "",
        @SerializedName("name")
        @Expose
        var name : String? = "",
        @SerializedName("productId")
        @Expose
        var productId : Int? = 0,
        @SerializedName("price")
        @Expose
        var price:Double? = 0.0
)