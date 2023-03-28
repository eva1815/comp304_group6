package com.example.group6.alexeva_comp304sec401_lab4_group6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var studentSignUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,getString(R.string.msg_home_page), Toast.LENGTH_SHORT).show()

        // Get the widgets reference from XML layout
        val imageCollegeLogo = findViewById<ImageView>(R.id.image_college_logo)

        // Display an image on image view from resource
        imageCollegeLogo.setImageResource(R.drawable.college_logo)

        studentSignUpButton = findViewById(R.id.btn_student_sign_up)

        studentSignUpButton.setOnClickListener{
            Log.i("TAG", "Sign Up button was Clicked!")
            val intent = Intent(this, StudentSignUpActivity::class.java)
            startActivity(intent)
        }

    }
}