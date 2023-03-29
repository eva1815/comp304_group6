package com.example.group6.alexeva_comp304sec401_lab4_group6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class BooksModuleActivity : AppCompatActivity() {
    private lateinit var allBooksFragment: AllBooksFragment
    private lateinit var fictionFragment: FictionFragment
    private lateinit var nonFictionFragment: NonFictionFragment
    private lateinit var educationalFragment: EducationalFragment
    private lateinit var historyFragment: HistoryFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var logOutFragment: LogOutFragment
    private lateinit var booksRecyclerView: RecyclerView
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

    }

    //create menu of books category
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.books_menu, menu)
        return true
    }
    private fun loadAllBooksFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frameToLoad, allBooksFragment)
            .commit()
    }
    private fun loadFictionFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frameToLoad, fictionFragment)
            .commit()
    }

    private fun loadNonFictionFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frameToLoad, nonFictionFragment)
            .commit()
    }

    private fun loadEducationalFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frameToLoad, educationalFragment)
            .commit()
    }

    private fun loadHistoryFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frameToLoad, historyFragment)
            .commit()
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
        //handle item selection
        when (item.itemId) {
            R.id.menu_all_books -> {
                Toast.makeText(this, "You Selected All Books", Toast.LENGTH_SHORT).show()
                loadAllBooksFragment()
            }
            R.id.menu_fiction -> {
                Toast.makeText(this, "You Selected Fiction", Toast.LENGTH_SHORT).show()
                loadFictionFragment()
            }
            R.id.menu_non_fiction -> {
                Toast.makeText(this, "You Selected Non-Fiction", Toast.LENGTH_SHORT).show()
                loadNonFictionFragment()
            }
            R.id.menu_educational -> {
                Toast.makeText(this, "You Selected Educational", Toast.LENGTH_SHORT).show()
                loadEducationalFragment()
            }
            R.id.menu_history -> {
                Toast.makeText(this, "You Selected History", Toast.LENGTH_SHORT).show()
                loadHistoryFragment()
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
}