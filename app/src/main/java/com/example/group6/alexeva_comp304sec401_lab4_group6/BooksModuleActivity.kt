package com.example.group6.alexeva_comp304sec401_lab4_group6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class BooksModuleActivity : AppCompatActivity() {

    private lateinit var fictionFragment: FictionFragment
    private lateinit var nonFictionFragment: NonFictionFragment
    private lateinit var educationalFragment: EducationalFragment
    private lateinit var historyFragment: HistoryFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_module)

        fictionFragment = FictionFragment()
        nonFictionFragment = NonFictionFragment()
        educationalFragment = EducationalFragment()
        historyFragment = HistoryFragment()

    }

    //create menu of books category
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.books_menu, menu)
        return true
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

    //click books category from menu when user choose books type
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //handle item selection
        when (item.itemId) {
            R.id.menu_fiction -> {
                Toast.makeText(this, "You Selected Fiction", Toast.LENGTH_SHORT).show()
                loadNonFictionFragment()
            }
            R.id.menu_non_fiction -> {
                Toast.makeText(this, "You Selected Non-Fiction", Toast.LENGTH_SHORT).show()
                loadNonFictionFragment()
            }
            R.id.menu_educational -> {
                Toast.makeText(this, "You Selected Educational", Toast.LENGTH_SHORT).show()
                loadNonFictionFragment()
            }
            R.id.menu_history -> {
                Toast.makeText(this, "You Selected History", Toast.LENGTH_SHORT).show()
                loadNonFictionFragment()
            }
            else -> return super.onOptionsItemSelected(item)

        }
        return true

    }
}