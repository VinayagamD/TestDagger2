package com.vinaylogics.testdagger2.base

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Vinay on 1/17/2018.
 */
abstract class BasePresenter : Presenter {

    private var compositeDisposable: CompositeDisposable? = null

    override fun onCreate() {

    }

    override fun onPause() {
    }

    override fun onResume() {
        configureDisposable()
    }

    override fun onDestroy() {
        unSubscribeAll()
    }

    protected fun unSubscribeAll() {
        if (compositeDisposable != null) {
            compositeDisposable?.dispose()
            compositeDisposable?.clear()
        }
    }

    protected fun configureDisposable(): CompositeDisposable? {
        if (compositeDisposable == null || compositeDisposable!!.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }

        return compositeDisposable
    }


    protected fun <F> subscribe(observable: Observable<F>, observer: Observer<F>) {
       observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer)

    }
}