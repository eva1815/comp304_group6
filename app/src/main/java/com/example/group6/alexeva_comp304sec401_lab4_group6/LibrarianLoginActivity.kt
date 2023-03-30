package com.example.group6.alexeva_comp304sec401_lab4_group6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.group6.alexeva_comp304sec401_lab4_group6.application.AppApplication
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Librarian
import com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel.LibrarianViewModel
import com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel.ViewModelFactory


class LibrarianLoginActivity : AppCompatActivity() {

    private lateinit var librarianLoginPageButton: Button
    private lateinit var librarianLoginID : EditText
    private lateinit var librarianLoginPassword : EditText

    private val librarianViewModel: LibrarianViewModel by viewModels {
        ViewModelFactory((application as AppApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_librarian_login)

        //Add dummy data to librarian_table
//        librarianViewModel.insert((Librarian("001", "Yash", "Sheth", "COMP304")))
//        librarianViewModel.insert((Librarian("007","James","Bond", "CasinoRoyale")))

        librarianLoginPageButton = findViewById(R.id.btn_librarian_login)
        librarianLoginID = findViewById(R.id.librarian_login_id)
        librarianLoginPassword = findViewById(R.id.librarian_login_password)




        librarianLoginPageButton.setOnClickListener {
            Log.i("TAG", "Sign Up button was Clicked!")
            val id = librarianLoginID.text.toString()
            val password = librarianLoginPassword.text.toString()

            if (id.isNotEmpty()) {
                librarianViewModel.getLibrarianById(id).observe(this) { librarian ->
                    if (librarian != null && librarian.password == password) {
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
            } else {
                Toast.makeText(
                    this,
                    "You must input an ID",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }



    }
}
