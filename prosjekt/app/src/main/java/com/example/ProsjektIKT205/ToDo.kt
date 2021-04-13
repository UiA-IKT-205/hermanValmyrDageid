package com.example.ProsjektIKT205

import android.app.Activity
import android.widget.ProgressBar


//create the data types for the project
data class ToDo(
    val name: String,
    val progressbar: Int,
    var checkBox: Boolean = false   //default false, no point in creating a list which is complete
)
