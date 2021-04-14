package com.example.ProsjektIKT205

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ProsjektIKT205.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    private var ToDos: MutableList<ToDo> = mutableListOf(ToDo("Hello, World!", 0, false))

    //var newToDoBtn = findViewById<Button>(R.id.newToDoBtn)    # could work, but it don't


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        AnonymousSignIn()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        Log.d("Actionbar", "Actionbar")
        binding.todoListing.layoutManager = LinearLayoutManager(this)
        binding.todoListing.adapter = todoAdapter(emptyList<ToDo>())
        todoManager.instance.onToDo = {
            (binding.todoListing.adapter as todoAdapter).updateCollection(it)
        }
        todoManager.instance.load()

        val todos = todoManager.instance

//        todoManager.instance.onToDo = {
//            (binding.todoListing.adapter as todoAdapter).updateCollection(it)
//        }


        val actionBar = supportActionBar
        actionBar!!.title = "Home"      //change title with an incredible one-liner without equal
        Log.d("Actionbar", "Actionbar")


//        ArrayList<newToDoActivity> exampleList = new ArrayList<>();
//        exampleList.add(new newToDoActivity("Line 1", 10, false))


//        newToDoBtn.setOnClickListener{      //should work but don't
//            val intent = Intent(this, newToDoActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun addToDo(title: String) {
        val todo = ToDo(title, 0)
        todoManager.instance.addToDo(todo)
    }

    private fun AnonymousSignIn(){
        auth.signInAnonymously().addOnSuccessListener {
            println("Sign in success ${it.user}")
            Log.d("MainActivity.kt","Successful login!")
        }.addOnFailureListener(){
            Log.e("MainActivity.kt", "Failed login :(", it)
        }
    }

    fun newToDo(view: View) {
        val intent = Intent(this, newToDoActivity::class.java)
        startActivity(intent)
    }
}