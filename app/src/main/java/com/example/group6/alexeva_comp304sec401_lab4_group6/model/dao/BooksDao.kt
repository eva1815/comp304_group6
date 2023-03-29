package com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books

@Dao
interface BooksDao {
    @Query("SELECT * FROM books_table ORDER BY bookId ASC")
    fun getBooksFromDB(): LiveData<List<Books>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(books: Books)

    // update books
    @Update
    suspend fun update(books: Books)

    //remove books in
    @Delete
    suspend fun delete(books: Books)

}