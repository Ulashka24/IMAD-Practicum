package com.sathiyavan.imadpracticum

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainMenu : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val textViewDay= findViewById<TextView>(R.id.textViewDay)
        val textViewMin= findViewById<TextView>(R.id.textViewMin)
        val textViewMax= findViewById<TextView>(R.id.textViewMax)
        val textViewWCond= findViewById<TextView>(R.id.textViewWCond)

        //Initialize them
        var i: Int = 0 //stores number of entries in array
        var display: String = "" //Display blank first
        val maxEntries = 7 //Only allow 7 array entries

        var averageMin: Int=0
        var averageMax: Int=0
        var averageTotal: Int=0
        var displayAverage: String= ""

        //create arrays
        val day = Array(maxEntries) { "" }
        val minimumTemperature = Array(maxEntries) {0}
        val maximumTemperature= Array (maxEntries) {0}
        val weatherCondition= Array (maxEntries) {""}

        val btnInsert= findViewById<Button>(R.id.btnInsert)
        val btnDetail= findViewById<Button>(R.id.btnDetail)
        val btnClear= findViewById<Button>(R.id.btnClear)

        btnInsert.setOnClickListener {
            //check if there's enough entries
            if (i < maxEntries) {
                //Convert to display types
                day[i] = textViewDay.text.toString()
                minimumTemperature[i] =
                    textViewMin.text.toString().toIntOrNull() ?: 0 // 0 is for error checking
                minimumTemperature[i] =
                    textViewMax.text.toString().toIntOrNull() ?: 0 //0 is for error checking
                weatherCondition[i] = textViewWCond.text.toString()
                i++ //Increment entry number

                Toast.makeText(this, "Entry added", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Maximum entries reached", Toast.LENGTH_SHORT).show()

            }
        }

        //Clear the TextViews
        btnClear.setOnClickListener {
            textViewDay.text= ""
            textViewMax.text=""
            textViewMin.text=""
            textViewWCond.text=""

        }
        //Button to navigate to details view
        btnDetail.setOnClickListener {
            display=""
            for (counter in 0 until 1) {
                display += "Date: ${day[counter]}\nMinTemp: ${minimumTemperature[counter]}\nMaxTemp: ${maximumTemperature[counter]}\nWeatherCondition: ${weatherCondition[counter]}\n\n"
                averageMin+= minimumTemperature[counter]
                averageMax+= maximumTemperature[counter]
                averageTotal+= minimumTemperature[counter] + maximumTemperature[counter]
            }

            averageTotal /=i
            averageMin /=i
            averageMax/=i

            displayAverage = "Average Min: ${averageMin}\nAverage Max: ${averageMax}\nAverage Time(Total): ${averageTotal}"


            //pass the data to DetailedViewsActivity and start the activity
            val intent= Intent(this,DetailView::class.java)
            intent.putExtra("DISPLAY_DATA", display)
            startActivity(intent)
        }
    }
}
