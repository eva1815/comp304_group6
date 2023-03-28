package com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Student
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(private val repository: StudentRepository):ViewModel() {
    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.

    val allStudentViewModel : LiveData<List<Student>> = repository.allStudentFromDB

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(student: Student) = viewModelScope.launch {
        repository.insert(student)
    }


}