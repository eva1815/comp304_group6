package com.example.group6.alexeva_comp304sec401_lab4_group6.model

import androidx.lifecycle.LiveData
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Student
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao.BooksDao
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao.LibrarianDao
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao.StudentDao

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class DatabaseRepository(private val librarianDao: LibrarianDao, private val studentDao: StudentDao, private val booksDao: BooksDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    // You can use LiveData instead and will notify the observer when there's a change
    val allBooksFromDB: LiveData<List<Books>> = librarianDao.getBooksFromDB()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.

    suspend fun insert(books: Books) {
        librarianDao.insert(books)
    }

    //not sure whether the librarian need to update bookId here?
    suspend fun update(books: Books) {
        println("REPOSITORY ${books.bookName} - ${books.authorName} - ${books.bookDescription} - ${books.category} - ${books.quantity}")
        librarianDao.update(books)
    }

    suspend fun delete(books: Books) {
        librarianDao.delete(books)
    }
    val allStudentFromDB: LiveData<List<Student>> = studentDao.getStudentFromDB()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.

    suspend fun insert(student: Student) {
        studentDao.insert(student)
    }
}