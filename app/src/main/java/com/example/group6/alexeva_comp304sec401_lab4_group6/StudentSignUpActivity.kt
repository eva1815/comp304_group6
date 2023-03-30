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
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Student
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.db.AppDatabase
import com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel.StudentViewModel
import com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel.ViewModelFactory

class StudentSignUpActivity : AppCompatActivity() {
    private lateinit var studentSignUpButton: Button
    private lateinit var backToHomeButton: Button

    private lateinit var studentIDEditText: EditText
    private lateinit var studentPasswordEditText: EditText
    private lateinit var studentFirstName:EditText
    private lateinit var studentLastName:EditText

    private val studentViewModel: StudentViewModel by viewModels {
        ViewModelFactory((application as AppApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_sign_up)
        Toast.makeText(this,getString(R.string.msg_sign_up_page), Toast.LENGTH_SHORT).show()

        // Get the widgets reference from XML layout
        val imageSignUpLogo = findViewById<ImageView>(R.id.image_sign_up_logo)

        // Display an image on image view from resource
        imageSignUpLogo.setImageResource(R.drawable.sign_up_logo)

        //Get user's input
        studentIDEditText = findViewById(R.id.edit_student_id_input)
        studentPasswordEditText = findViewById(R.id.edit_student_password_input)
        studentFirstName = findViewById(R.id.edit_student_firstName_input)
        studentLastName = findViewById(R.id.edit_student_lastName_input)


        studentSignUpButton = findViewById(R.id.btn_student_sign_up_success)
        backToHomeButton = findViewById(R.id.btn_back_to_home_page)

        studentSignUpButton.setOnClickListener{
            // Get the values entered by the user
            val studentID = studentIDEditText.text.toString().toIntOrNull()
            val password = studentPasswordEditText.text.toString().trim()
            val firstName = studentFirstName.text.toString().trim()
            val lastName = studentLastName.text.toString().trim()

            // Check if any of the fields are empty
            if (studentID == null || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
            } else {
                // Save the student information in the database
                studentViewModel.insert(Student(studentID,firstName,lastName,password))

                Toast.makeText(this, "Student information saved successfully", Toast.LENGTH_SHORT).show()


                // Open the StudentLoginActivity
//                val intent = Intent(this, StudentLoginActivity::class.java)
//                startActivity(intent)
            }
        }

        backToHomeButton.setOnClickListener {
            Log.i("TAG", "Home button was Clicked!")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}