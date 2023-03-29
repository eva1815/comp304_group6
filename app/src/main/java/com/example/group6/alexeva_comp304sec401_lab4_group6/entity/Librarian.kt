package com.example.group6.alexeva_comp304sec401_lab4_group6.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "librarian_table")
class Librarian (
        // I deleted (autoGenerate = true) to make it not auto Generate
        // Librarian table will be input manually
        @PrimaryKey @ColumnInfo(name = "librarianId")
        val librarianId: String,

        @ColumnInfo(name = "firstname")
        var firstname: String,

        @ColumnInfo(name = "lastname")
        var lastname: String,

        @ColumnInfo(name = "password")
        var password: String
)