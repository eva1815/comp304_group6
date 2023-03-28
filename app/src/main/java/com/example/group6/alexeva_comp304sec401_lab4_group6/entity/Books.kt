package com.example.group6.alexeva_comp304sec401_lab4_group6.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table")
class Books (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "bookId")
    val bookId: Int?,

    @ColumnInfo(name = "bookName")
    var bookName: String,

    @ColumnInfo(name = "authorName")
    var authorName: String,

    @ColumnInfo(name = "bookDescription")
    var bookDescription: String,

    @ColumnInfo(name = "category")
    var category: String,

    @ColumnInfo(name = "quantity")
    var quantity: Int
)
