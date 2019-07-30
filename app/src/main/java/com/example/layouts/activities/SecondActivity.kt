package com.example.layouts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(){

    //using companion objects
    companion object {

        //defining a constant value
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //get the new intent
        //bundle represents a data type that is nullable
        val bundle : Bundle? = intent.extras

        //use the null safety operator to bundle to check that it is not null
            bundle?.let {

                //we have to use !! to nullify it
                val msg = bundle.getString(Constants.USER_MSG_KEY)

                showToast(msg)

                //get the text view in the xml file and set the text to it
                txvUserMessage.text = msg
            }

    }

}