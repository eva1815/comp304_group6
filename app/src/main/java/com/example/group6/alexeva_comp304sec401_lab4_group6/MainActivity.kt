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
    private lateinit var librarianLoginHomePageButton : Button
    private lateinit var studentLoginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,getString(R.string.msg_home_page), Toast.LENGTH_SHORT).show()

        // Get the widgets reference from XML layout
        val imageCollegeLogo = findViewById<ImageView>(R.id.image_college_logo)

        // Display an image on image view from resource
        imageCollegeLogo.setImageResource(R.drawable.college_logo)

        studentLoginButton = findViewById(R.id.btn_student_login)
        studentSignUpButton = findViewById(R.id.btn_student_sign_up)
        librarianLoginHomePageButton = findViewById(R.id.btn_librarian_login_home_page)

        studentLoginButton = findViewById(R.id.btn_student_login)

        studentLoginButton.setOnClickListener {
            Log.i("TAG", "Student Login button was Clicked!")
            val intent = Intent(this,StudentLoginActivity::class.java)
            startActivity(intent)
        }

        studentSignUpButton.setOnClickListener{
            Log.i("TAG", "Sign Up button was Clicked!")
            val intent = Intent(this, StudentSignUpActivity::class.java)
            startActivity(intent)
        }
        librarianLoginHomePageButton.setOnClickListener {
            Log.i("TAG", "Sign Up button was Clicked!")
            val intent = Intent(this, LibrarianLoginActivity::class.java)
            startActivity(intent)
        }


    }
}