package com.example.group6.alexeva_comp304sec401_lab4_group6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books
import com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel.BooksViewModel
import java.text.SimpleDateFormat
import java.util.*

class AddEditBooksActivity : AppCompatActivity() {
    private lateinit var booksTitleEditText: EditText
    private lateinit var booksAuthorNameEditText: EditText
    private lateinit var booksDescriptionEditText: EditText
    private lateinit var booksCategoryEditText: EditText
    private lateinit var booksQuantityEditText: EditText
    private lateinit var addUpdateButton: Button

    private lateinit var viewModel: BooksViewModel
    var bookId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_books)

        intent.putExtra("userRole","Librarian")


        booksTitleEditText = findViewById(R.id.editText_id_books_title)
        booksAuthorNameEditText = findViewById(R.id.editText_id_books_author_name)
        booksDescriptionEditText = findViewById(R.id.editText_id_books_description)
        booksCategoryEditText = findViewById(R.id.editText_id_books_category)
        booksQuantityEditText = findViewById(R.id.editText_id_books_quantity)
        addUpdateButton = findViewById(R.id.btn_id_add_update)
        viewModel= ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(BooksViewModel::class.java)

        val booksType = intent.getStringExtra("booksType")
        if(booksType.equals("Edit")){
            val bookName = intent.getStringExtra("bookName")
            val authorName = intent.getStringExtra("authorName")
            val bookDescription = intent.getStringExtra("bookDescription")
            val category = intent.getStringExtra("category")
            val quantity = intent.getStringExtra("quantity")
            bookId = intent.getIntExtra("bookId",-1)

            addUpdateButton.setText("Update Books")
            booksTitleEditText.setText(bookName)
            booksAuthorNameEditText.setText(authorName)
            booksDescriptionEditText.setText(bookDescription)
            booksCategoryEditText.setText(category)
            booksQuantityEditText.setText(quantity)
        }
        else{
            addUpdateButton.setText("Save Books")
        }

        addUpdateButton.setOnClickListener {
            val bookName = booksTitleEditText.text.toString()
            val authorName = booksAuthorNameEditText.text.toString()
            val bookDescription = booksDescriptionEditText.text.toString()
            val category = booksCategoryEditText.text.toString()
            val quantity = booksQuantityEditText.text.toString()

            if (booksType.equals("Edit")) {
                if (bookName.isNotEmpty() && authorName.isNotEmpty() && bookDescription.isNotEmpty() && category.isNotEmpty() && quantity.isNotEmpty()) {
//                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
//                    var currentDate: String = sdf.format(Date())
                    var updateBooks = Books(
                        bookName,
                        authorName,
                        bookDescription,
                        category,
                        quantity)
                    updateBooks.bookId = bookId
                    viewModel.updateBooks(updateBooks)
                    Toast.makeText(this, "Books Updated", Toast.LENGTH_LONG).show()

                }
            } else {
                if (bookName.isNotEmpty() && authorName.isNotEmpty() && bookDescription.isNotEmpty() && category.isNotEmpty() && quantity.isNotEmpty()) {
//                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
//                    var currentDate: String = sdf.format(Date())
                    viewModel.addBooks(Books(
                        bookName,
                        authorName,
                        bookDescription,
                        category,
                        quantity
                       ))
                    Toast.makeText(this, "Books Added", Toast.LENGTH_LONG).show()

                }
            }
            val intent = Intent(this, BooksModuleActivity::class.java)
            //Add userRole as switch to show or hide function
            intent.putExtra("userRole","Librarian")
            startActivity(intent)
            this.finish()
        }
    }
}