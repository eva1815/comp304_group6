package com.example.group6.alexeva_comp304sec401_lab4_group6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class StudentLoginActivity : AppCompatActivity() {
    private lateinit var editTextStudentId: EditText
    private lateinit var editTextStudentPassword: EditText
    private lateinit var buttonStudentLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_login)
        Toast.makeText(this,getString(R.string.msg_student_login), Toast.LENGTH_SHORT).show()
        // Get the widgets reference from XML layout
        val imageSignInLogo = findViewById<ImageView>(R.id.image_student_login_logo)

        // Display an image on image view from resource
        imageSignInLogo.setImageResource(R.drawable.student_login)


    }
}