package com.example.layouts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.layouts.adapters.HobbiesAdapter
import com.example.layouts.models.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity(){

    //using companion objects
    companion object {

        //defining a constant value
        val TAG: String = HobbiesActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //defining the layout the activity will be using
        setContentView(R.layout.activity_hobbies)

        setUpRecyclerView()

        //define the layout manager you want to use
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        //attach the layout manager to the recycler view
        recyclerView.layoutManager = layoutManager

        //initalize the hobbies adapter
        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        recyclerView.adapter = adapter

    }

    private fun setUpRecyclerView() {

        //define the layout manager you want to use
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        //attach the layout manager to the recycler view
        recyclerView.layoutManager = layoutManager

        //initalize the hobbies adapter
        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        recyclerView.adapter = adapter

    }

    fun recyAdd(a: Int, b:Int){

    }
}