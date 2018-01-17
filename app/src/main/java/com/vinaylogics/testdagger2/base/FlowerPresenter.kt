package com.vinaylogics.testdagger2.base

import com.vinaylogics.testdagger2.model.Flower
import com.vinaylogics.testdagger2.services.IFlowerView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Vinay on 1/17/2018.
 */
class FlowerPresenter(val view:IFlowerView):BasePresenter(),Observer<List<Flower>> {


    override fun onSubscribe(d: Disposable) {
        configureDisposable()?.add(d)
    }

    override fun onNext(t: List<Flower>) {
        view.flowers(t)
    }

    override fun onComplete() {
          view.completed()
    }

    override fun onError(e: Throwable) {
        view.error(e.message)
    }

    fun fetchFlowers() {
        unSubscribeAll()
        subscribe(view.getFlowers(),this)
    }

}