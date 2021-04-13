package com.example.ProsjektIKT205

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class newToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_to_do)

        val actionBar = supportActionBar

        actionBar!!.title = "New List"
        actionBar.setDisplayHomeAsUpEnabled(true)   //reference back to main


    }
}