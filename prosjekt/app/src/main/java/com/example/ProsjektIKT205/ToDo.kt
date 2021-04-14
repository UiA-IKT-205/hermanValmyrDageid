package com.example.ProsjektIKT205

//create the data types for the project
data class ToDo(    //reason for parenthesis and not curly brackets since this is only supposed to hold data
    val name: String,
    val progressbar: Int,
    var checkBox: Boolean = false   //default false, no point in creating a list which is complete
 )
