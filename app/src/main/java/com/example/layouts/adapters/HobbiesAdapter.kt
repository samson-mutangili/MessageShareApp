package com.example.layouts.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.layouts.R
import com.example.layouts.models.Hobby
import com.example.layouts.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        //inflate the layouts
        //the inflate method returns the layout as a view
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        //return the view
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        //return the size of the hobbies list
        return hobbies.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //this method is responsible for binding data to the views that are being created,
        //it is used to combine data with the view

        //get the item at the position
        val hobby = hobbies[position]
        //set the data
        holder.setData(hobby, position)
    }

    // inorder to bind data to each of the views, we need to have a class
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currentHobby: Hobby? = null
        var currentPosition:Int = 0

        //set an event listener so that a person is able to click on each of the hobbies
       init{
            itemView.setOnClickListener{

                //use null safety operation to ensure that the code will not be executed when there is no data
                currentHobby?.let {

                    //Make some toast message using the extension function
                    context.showToast(currentHobby!!.title + " Clicked")

                }
            }

            itemView.imgShare.setOnClickListener{

                //execute the following lines of code if not the current hobby is not null
                currentHobby?.let {

                    //set the title of the hobby
                    val message: String = "My hobby is " + currentHobby!!.title

                    //make a new intent
                    val imgIntent = Intent()
                    //set the action
                    imgIntent.action = Intent.ACTION_SEND
                    //put the message to be send
                    imgIntent.putExtra(Intent.EXTRA_TEXT, message)
                    //set the data type
                    imgIntent.type = "text/plain"

                    //start the intent
                    context.startActivity(Intent.createChooser(imgIntent, "Please select the app: "))
                }
            }
        }

        //define a function
        fun setData(hobby : Hobby?, pos: Int){

            hobby?.let {
                itemView.txvTitle.text = hobby.title

            }

            //set the title of the current hobby
            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}