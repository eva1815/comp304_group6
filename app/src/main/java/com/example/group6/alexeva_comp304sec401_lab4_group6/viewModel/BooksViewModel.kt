package com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel


import android.app.Application
import androidx.lifecycle.*
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.BooksRepository
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//class BooksViewModel(private val repository: DatabaseRepository):ViewModel() {
//    // Using LiveData and caching what allWords returns has several benefits:
//    // - We can put an observer on the data (instead of polling for changes) and only update the
//    //   the UI when the data actually changes.
//    // - Repository is completely separated from the UI through the ViewModel.
//
//    val allBooksViewModel : LiveData<List<Books>> = repository.allBooks
//
//}
//
class BooksViewModel (application: Application):AndroidViewModel(application){
    val allBooks : LiveData<List<Books>>
    val repository : BooksRepository

    init{
        val dao = AppDatabase.getDatabase(application).booksDao()
        repository = BooksRepository(dao)
        allBooks = repository.allBooks
    }

    fun deleteBooks(books: Books) = viewModelScope.launch (Dispatchers.IO){
        repository.delete( books)
    }

    fun updateBooks(books: Books) = viewModelScope.launch (Dispatchers.IO){
        repository.update(books)
    }

    fun addBooks(books: Books) = viewModelScope.launch (Dispatchers.IO){
        repository.insert(books)
    }
    fun getBooksByIds(bookIds: List<Int>): LiveData<List<Books>> {
        return repository.getBooksByIds(bookIds)
    }


    //The following function is a category filter
    //Reference: https://developer.android.com/topic/libraries/architecture/livedata
    //Check the LiveData and ViewModel for more information

    fun filterBooksByCategory(category: String): LiveData<List<Books>> {
        return allBooks.map { list ->
            list.filter { it.category == category }
        }
    }

}