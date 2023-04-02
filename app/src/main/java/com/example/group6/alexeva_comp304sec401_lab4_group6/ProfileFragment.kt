package com.example.group6.alexeva_comp304sec401_lab4_group6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books
import com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel.BooksViewModel


class ProfileFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the borrowedBookIds
        val borrowedBookIds = arguments?.getIntegerArrayList("borrowedBookIds") ?: arrayListOf()

        val borrowedBooksRecyclerView: RecyclerView = requireView().findViewById(R.id.recyclerView_borrowedBooks)
        borrowedBooksRecyclerView.layoutManager = LinearLayoutManager(context)

        val borrowedBooksAdapter = BooksRVAdapter(requireContext(), object : BooksClickDeleteInterface {
            override fun onDeleteIconClick(books: Books) {
                // Do nothing, since we don't want to delete books in the ProfileFragment
            }
        }, object : BooksClickInterface {
            override fun onBooksClick(books: Books) {
                // Do nothing, since we don't want to edit books in the ProfileFragment
            }
        }, object : BooksClickBorrowedInterface {
            override fun onBorrowIconClick(book: Books) {
                // Do nothing, since we don't want to borrow books in the ProfileFragment
            }
        }, userRole = "Student") // Set the userRole to "Student" to hide delete and edit buttons

        borrowedBooksRecyclerView.adapter = borrowedBooksAdapter

        // Get the ViewModel
        val viewModel = ViewModelProvider(requireActivity()).get(BooksViewModel::class.java)

        // Observe the borrowedBooks LiveData
        viewModel.getBooksByIds(borrowedBookIds).observe(viewLifecycleOwner) { borrowedBooks ->
            borrowedBooksAdapter.updateList(borrowedBooks)
        }
    }


}