package com.example.ProsjektIKT205

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.example.ProsjektIKT205.databinding.ActivityNewToDoBinding

class newToDoActivity : AppCompatActivity() {

    private lateinit var saveButton: Button         //objects required to save to Firebase
    private lateinit var editTextName: EditText
    private lateinit var binding: ActivityNewToDoBinding
    lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val actionBar = supportActionBar
        actionBar!!.title = "New List"
        actionBar.setDisplayHomeAsUpEnabled(true)   //reference back to main

        //editTextName = findViewById(R.id.todoName)
        saveButton = findViewById(R.id.saveElement)

        saveButton.setOnClickListener() {
            val name = editTextName.text.toString()
            val progressBar = 0
            addToDo(name, progressBar)

            //saveToDo()
            returnToHome()
        }


    }

    private fun returnToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun addToDo(title: String, progressBar: Int) {
        val todo = ToDo(title, progressBar, false)
    }


//    private fun saveToDo() {
//        val name = editTextName.text.toString()
//
//        if (name.isEmpty()) {
//            editTextName.error = "Enter a Title"
//            return      //just stop execution
//        }
//        val ref =
//            FirebaseDatabase.getInstance().getReference("todos")  //create reference to the firebase
//        val ToDoID = ref.push().key     //create a unique key
//
//        val todo =
//            ToDo(ToDoID, name, progressbar = 0, checkBox = false)    //progressbar defaulted to 0
//        Log.d("fun savetodo()", "before null")
//
//        if (ToDoID != null) {
//            ref.child(ToDoID).setValue(todo).addOnCompleteListener {
//                Toast.makeText(applicationContext, "We did it boys", Toast.LENGTH_LONG).show()
//            }
//        }
//
//        if (ToDoID != null) {
//            ref.child(ToDoID).setValue(todo)
//            Log.d("null", "should be pushed?")
//            Toast.makeText(applicationContext, "We did it boys", Toast.LENGTH_LONG).show()
//        }
//    }
}