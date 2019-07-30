package com.example.layouts

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT){
    //show the toast
    Toast.makeText(this, message, duration).show()

}