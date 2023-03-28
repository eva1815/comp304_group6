package com.example.group6.alexeva_comp304sec401_lab4_group6.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "librarian_table")
class Librarian (
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "librarianId")
        val librarianId: Int?,

        @ColumnInfo(name = "firstname")
        var firstname: String,

        @ColumnInfo(name = "lastname")
        var lastname: String,

        @ColumnInfo(name = "password")
        var password: String
)