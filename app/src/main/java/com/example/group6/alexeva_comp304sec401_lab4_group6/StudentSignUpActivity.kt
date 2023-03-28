package com.example.group6.alexeva_comp304sec401_lab4_group6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.group6.alexeva_comp304sec401_lab4_group6.R

class StudentSignUpActivity : AppCompatActivity() {
    private lateinit var studentSignUpButton: Button
    private lateinit var backToHomeButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_sign_up)
        Toast.makeText(this,getString(R.string.msg_sign_up_page), Toast.LENGTH_SHORT).show()

        // Get the widgets reference from XML layout
        val imageSignUpLogo = findViewById<ImageView>(R.id.image_sign_up_logo)

        // Display an image on image view from resource
        imageSignUpLogo.setImageResource(R.drawable.sign_up_logo)

        studentSignUpButton = findViewById(R.id.btn_student_sign_up_success)
        backToHomeButton = findViewById(R.id.btn_back_to_home_page)

        studentSignUpButton.setOnClickListener{
            Log.i("TAG", "Sign Up button was Clicked!")
            val intent = Intent(this, StudentLoginActivity::class.java)
            startActivity(intent)
        }

        backToHomeButton.setOnClickListener {
            Log.i("TAG", "Home button was Clicked!")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}