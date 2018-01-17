package com.vinaylogics.testdagger2.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.DiskCache
import com.vinaylogics.testdagger2.R
import com.vinaylogics.testdagger2.model.Flower
import com.vinaylogics.testdagger2.utils.Constant
import kotlinx.android.synthetic.main.item_flower.view.*

/**
 * Created by Vinay on 1/17/2018.
 */
class FlowerAdapter(val layoutInflater: LayoutInflater, var flowers:MutableList<Flower>? = ArrayList()):RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {
    override fun getItemCount(): Int = flowers.orEmpty().size

    override fun onBindViewHolder(holder: FlowerViewHolder?, position: Int) {
        try {
            holder?.setData(flowers.orEmpty()[position])
        }catch (t:Throwable){
            t.printStackTrace()
        }
    }

    fun updateFlowers( flowers: List<Flower>?){
        try {
            this.flowers?.clear()
            this.flowers?.addAll(flowers.orEmpty())
            notifyDataSetChanged()
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FlowerViewHolder =
            FlowerViewHolder(layoutInflater.inflate(R.layout.item_flower,parent,false))


    inner  class FlowerViewHolder( itemView: View): RecyclerView.ViewHolder(itemView){
        private var nameTextView: TextView? = null
        private var priceTextView: TextView? = null
        private var flowerImageView: ImageView? = null

        init {
            nameTextView = itemView.nameTextView
            priceTextView = itemView.priceTextView
            flowerImageView = itemView.floawerImageView
        }

        fun setData(flower: Flower){
            nameTextView?.text = flower.name.orEmpty()
            priceTextView?.text = flower.price.toString()
            flowerImageView?.let {
                Glide
                        .with(itemView.context)

                        .load("${Constant.PHOTO_URL}${flower.photo.orEmpty()}")

                        .into(it) }

        }
    }
}