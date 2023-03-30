package com.example.group6.alexeva_comp304sec401_lab4_group6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.group6.alexeva_comp304sec401_lab4_group6.application.AppApplication
import com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel.LibrarianViewModel
import com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel.StudentViewModel
import com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel.ViewModelFactory

class StudentLoginActivity : AppCompatActivity() {

    private lateinit var editTextStudentId: EditText
    private lateinit var editTextStudentPassword: EditText
    private lateinit var buttonStudentLogin: Button

    private val studentViewModel: StudentViewModel by viewModels {
        ViewModelFactory((application as AppApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_login)
        Toast.makeText(this,getString(R.string.msg_student_login), Toast.LENGTH_SHORT).show()
        // Get the widgets reference from XML layout
        val imageSignInLogo = findViewById<ImageView>(R.id.image_student_login_logo)

        // Display an image on image view from resource
        imageSignInLogo.setImageResource(R.drawable.student_login)

        buttonStudentLogin = findViewById(R.id.btn_student_login)
        editTextStudentId = findViewById(R.id.edit_student_id_input)
        editTextStudentPassword = findViewById(R.id.edit_student_password_input)

        buttonStudentLogin.setOnClickListener {

            val id = editTextStudentId.text.toString().toIntOrNull()
            val password = editTextStudentPassword.text.toString()

            if (id != null){
                studentViewModel.getStudentById(id).observe(this) { student ->
                    if (student != null && student.password == password) {
                        val intent = Intent(this, BooksModuleActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this,
                            "Invalid ID or password. Please try again.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }else{
                Toast.makeText(
                    this,
                    "You must input an ID",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }

    }
}