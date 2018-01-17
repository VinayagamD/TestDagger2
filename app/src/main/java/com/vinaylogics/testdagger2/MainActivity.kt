package com.vinaylogics.testdagger2

import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.vinaylogics.testdagger2.adapters.FlowerAdapter
import com.vinaylogics.testdagger2.base.FlowerPresenter
import com.vinaylogics.testdagger2.core.FlowerApplication
import com.vinaylogics.testdagger2.model.Flower
import com.vinaylogics.testdagger2.services.FlowerService
import com.vinaylogics.testdagger2.services.IFlowerView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.progress_layout.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),IFlowerView {


    override fun getFlowers(): Observable<List<Flower>> {
        return flowerService.getFlowers()
    }

    override fun flowers(flowers: List<Flower>) {
        flowerAdapter.updateFlowers(flowers)
    }

    override fun completed() {
        progressConstraintLayout.visibility = View.GONE
    }

    override fun error(message: String?) {
        progressConstraintLayout.visibility = View.GONE
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    @Inject
    lateinit  var flowerService: FlowerService
    lateinit var presenter: FlowerPresenter
    lateinit var flowerAdapter: FlowerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resolveDependency()
        configureView()
        presenter = FlowerPresenter(this)
        presenter.onCreate()
    }



    private fun resolveDependency() {
        (application as FlowerApplication).component.inject(this)
    }

    private fun configureView() {
        flowerRecyclerView.recycledViewPool = RecyclerView.RecycledViewPool()
        flowerRecyclerView.layoutManager = LinearLayoutManager(this)
        flowerRecyclerView.setHasFixedSize(true)
        flowerRecyclerView.itemAnimator = DefaultItemAnimator()
        flowerAdapter = FlowerAdapter(LayoutInflater.from(this))
        flowerRecyclerView.adapter = flowerAdapter
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
        presenter.fetchFlowers()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
