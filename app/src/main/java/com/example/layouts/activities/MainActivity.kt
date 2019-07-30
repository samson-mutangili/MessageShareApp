package com.example.layouts

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //using companion objects
    companion object {

        //defining a constant value
         val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener{

            //display information to the log file
            Log.i(TAG, "The button was clicked");

            //Using the extension function to show some toast
            showToast(resources.getString(R.string.btn_was_clicked), Toast.LENGTH_LONG)

        }

        //listent to the button for sharing data btn two activities
        btnSendData.setOnClickListener {

            //get the text from the edit text view and store it to a variable
            val message: String = etUserMessage.text.toString();

            //show the message as a toast
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


            //we navigate to different activities through the use of intents
            //the double semicolns represents the concept of reflection
            val intent = Intent(this, SecondActivity::class.java)


            //put the message to the intent
            intent.putExtra(Constants.USER_MSG_KEY  , message)

            //start the activity
            startActivity(intent)
        }

        //event listener for the second button
        btnShareToOtherApps.setOnClickListener{

            //get the text form the user
            val message: String = etUserMessage.text.toString()

            //set a new intent that does not have any parameters since we dont know which activity we are passing data to
            val intent = Intent()
            //set the action
            intent.action = Intent.ACTION_SEND
            //put the message to the intent
            intent.putExtra(Intent.EXTRA_TEXT, message)
            //specify the type of the message
            intent.type = "text/plain"
            //start the activity
            startActivity(Intent.createChooser(intent, "Share to: "))
        }

        //set the action for the recycler button
        btnRecyclerView.setOnClickListener{


            //make an intent
            val recylerIntent = Intent(this, HobbiesActivity::class.java)
            startActivity(recylerIntent)
        }

        
    }
}
