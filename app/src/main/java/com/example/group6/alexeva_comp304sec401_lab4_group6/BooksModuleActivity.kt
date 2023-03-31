package com.example.group6.alexeva_comp304sec401_lab4_group6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books
import com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel.BooksViewModel

class BooksModuleActivity : AppCompatActivity(), BooksClickDeleteInterface, BooksClickInterface {
    private lateinit var allBooksFragment: AllBooksFragment
    private lateinit var fictionFragment: FictionFragment
    private lateinit var nonFictionFragment: NonFictionFragment
    private lateinit var educationalFragment: EducationalFragment
    private lateinit var historyFragment: HistoryFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var logOutFragment: LogOutFragment

    private lateinit var booksRecyclerView: RecyclerView
    private lateinit var addBooksButton:Button
    private lateinit var viewModel: BooksViewModel

    private lateinit var userRole: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_module)

        allBooksFragment= AllBooksFragment()
        fictionFragment = FictionFragment()
        nonFictionFragment = NonFictionFragment()
        educationalFragment = EducationalFragment()
        historyFragment = HistoryFragment()
        profileFragment = ProfileFragment()
        logOutFragment = LogOutFragment()
        booksRecyclerView = findViewById(R.id.id_rv_books)
        addBooksButton = findViewById(R.id.btn_id_add_books)
        booksRecyclerView.layoutManager = LinearLayoutManager(this)

        //If user is student, hide books icon
        userRole = intent.getStringExtra("userRole") ?: "Student"

        if (userRole == "Student") {
            addBooksButton.visibility = View.GONE
        }

        val booksRVAdapter = BooksRVAdapter(this,this,this, userRole)
        booksRecyclerView.adapter = booksRVAdapter
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(BooksViewModel::class.java)
        viewModel.allBooks.observe(this, Observer{ list->
            list?.let{
                booksRVAdapter.updateList(it)
            }
        })
        addBooksButton.setOnClickListener{
            val intent = Intent(this@BooksModuleActivity,AddEditBooksActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    //create menu of books category
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.books_menu, menu)
        return true
    }

    private fun loadProfileFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frameToLoad, profileFragment)
            .commit()
    }

    private fun loadLogOutFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frameToLoad, logOutFragment)
            .commit()
    }



    //click books category from menu when user choose books type
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        //Reload RecycleView, According to menu Item selection
        booksRecyclerView = findViewById(R.id.id_rv_books)
        val booksRVAdapter = BooksRVAdapter(this,this,this, userRole)
        booksRecyclerView.adapter = booksRVAdapter
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(BooksViewModel::class.java)
        //handle item selection

        when (item.itemId) {
            R.id.menu_all_books -> {
                Toast.makeText(this, "You Selected All Books", Toast.LENGTH_SHORT).show()
                viewModel.allBooks.observe(this, Observer{
                        list ->list?.let{
                    booksRVAdapter.updateList(it)
                }
                })
            }
            R.id.menu_fiction -> {
                Toast.makeText(this, "You Selected Fiction", Toast.LENGTH_SHORT).show()
                viewModel.filterBooksByCategory("Fiction").observe(this, Observer { list ->
                    list?.let {
                        booksRVAdapter.updateList(it)
                    }
                })
            }
            R.id.menu_non_fiction -> {
                Toast.makeText(this, "You Selected Non-Fiction", Toast.LENGTH_SHORT).show()
                viewModel.filterBooksByCategory("Non-Fiction").observe(this, Observer { list ->
                    list?.let {
                        booksRVAdapter.updateList(it)
                    }
                })
            }
            R.id.menu_educational -> {
                Toast.makeText(this, "You Selected Educational", Toast.LENGTH_SHORT).show()
                viewModel.filterBooksByCategory("Educational").observe(this, Observer { list ->
                    list?.let {
                        booksRVAdapter.updateList(it)
                    }
                })
            }
            R.id.menu_history -> {
                Toast.makeText(this, "You Selected History", Toast.LENGTH_SHORT).show()
                viewModel.filterBooksByCategory("History").observe(this, Observer { list ->
                    list?.let {
                        booksRVAdapter.updateList(it)
                    }
                })
            }
            R.id.menu_profile -> {
                Toast.makeText(this, "You Selected Profile", Toast.LENGTH_SHORT).show()
                loadProfileFragment()
            }
            R.id.menu_log_out -> {
                Toast.makeText(this, "You Selected Log Out", Toast.LENGTH_SHORT).show()
                loadLogOutFragment()
            }
            else -> return super.onOptionsItemSelected(item)

        }
        return true

    }

    override fun onDeleteIconClick(books: Books) {
    viewModel.deleteBooks(books)
        Toast.makeText(this,"${books.bookName} Deleted",Toast.LENGTH_LONG).show()
    }

    override fun onBooksClick(books: Books) {
        val intent = Intent(this@BooksModuleActivity,AddEditBooksActivity::class.java)
        intent.putExtra("booksType","Edit")
        intent.putExtra("bookName",books.bookName)
        intent.putExtra("authorName",books.authorName)
        intent.putExtra("bookDescription",books.bookDescription)
        intent.putExtra("category",books.category)
        intent.putExtra("quantity",books.quantity)
        intent.putExtra("bookId", books.bookId)
        startActivity(intent)
        this.finish()
    }
}