package com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Librarian
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Student

@Dao
interface StudentDao {
    //Student can also see all the books currently in the library (Viewing)
    @Query("SELECT * FROM student_table ORDER BY studentId ASC")
    fun getStudentFromDB(): LiveData<List<Student>>

    // Student to add their information in the student
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Query("SELECT * FROM student_table WHERE studentId = :id")
    fun getStudentById(id: Int): LiveData<Student>


}