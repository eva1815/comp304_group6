package com.example.group6.alexeva_comp304sec401_lab4_group6.model

import androidx.lifecycle.LiveData
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao.BooksDao

class BooksRepository (private val booksDao:BooksDao){

    val allBooks: LiveData<List<Books>> = booksDao.getBooksFromDB()

    suspend fun insert(books: Books) {
        booksDao.insert(books)
    }


    //not sure whether the librarian need to update bookId here?
    suspend fun update(books: Books) {
        booksDao.update(books)
    }

    suspend fun delete(books: Books) {
        booksDao.delete(books)
    }
    fun getBooksByIds(bookIds: List<Int>): LiveData<List<Books>> {
        return booksDao.getBooksByIds(bookIds)
    }
}