package com.sathiyavan.imadpracticum

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetailView : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view)

        val btnDetails: Button = findViewById<Button>(R.id.btnDetail)
        btnDetails.setOnClickListener {
            val intent = Intent(this, DetailView::class.java)
            startActivity(intent)
        }

        val btnExit: Button = findViewById(R.id.btnMain)
        btnExit.setOnClickListener {
            val intent = Intent(this, DetailView::class.java)
            System.exit(0)
        }
    }
}