package com.example.ProsjektIKT205

import android.content.Context
import android.widget.ProgressBar


class todoManager {
    private lateinit var todoCollection: MutableList<ToDo>

    var onToDo: ((List<ToDo>) -> Unit)? = null
    var onToDoUpdate: ((todo:ToDo) -> Unit)? = null
    //var progressBar = ProgressBar(null)

    fun load(url: String, context:Context){
        todoCollection = mutableListOf(
            ToDo( "Trying my best", 0, false),  //test data
            ToDo("almost my best", 0, false)
        )

        onToDo?.invoke(todoCollection)
    }

    fun updateToDo(todo:ToDo){
        onToDoUpdate?.invoke(todo)
    }

    fun addToDo(todo: ToDo){
        todoCollection.add(todo)
        onToDo?.invoke(todoCollection)
    }

    companion object {
       val instance = todoManager()
    }

}