package com.example.group6.alexeva_comp304sec401_lab4_group6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class LibrarianLoginActivity : AppCompatActivity() {
    private lateinit var librarianLoginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_librarian_login)

        librarianLoginButton = findViewById(R.id.btn_librarian_login)
        Log.i("TAG", "Librarian Login button was Clicked!")
        val intent = Intent(this,BooksModuleActivity::class.java)
        startActivity(intent)
    }
}