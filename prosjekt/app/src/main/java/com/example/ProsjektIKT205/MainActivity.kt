package com.example.ProsjektIKT205

import android.content.Intent
import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.ProsjektIKT205.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.net.ssl.SSLSessionBindingEvent


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    private lateinit var ToDos: MutableList<ToDo>
    //var newToDoBtn = findViewById<Button>(R.id.newToDoBtn)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("onCreate", "onCreate")

        auth = Firebase.auth
        Log.d("auth", "auth")
        AnonymousSignIn()
        Log.d("AnonymousSignIn", "AnonymousSignIn")

        setContentView(R.layout.activity_main)
        Log.d("ContextView", "ContextView")


        val actionBar = supportActionBar
        actionBar!!.title = "Home"      //change title with an incredible one-liner without equal
        Log.d("Actionbar", "Actionbar")

//        newToDoBtn.setOnClickListener{      //should fucking work, wtf.
//            val intent = Intent(this, newToDoActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun AnonymousSignIn(){
        auth.signInAnonymously().addOnSuccessListener {
            println("Sign in success ${it.user}")    //what is this warning even ${it.user}
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