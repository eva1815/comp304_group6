package com.example.group6.alexeva_comp304sec401_lab4_group6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books

class BooksRVAdapter(
    val context:Context,
    private val booksClickDeleteInterface: BooksClickDeleteInterface,
    private val booksClickInterface: BooksClickInterface,
    // Add the booksClickBorrowedInterface parameter
    private val booksClickBorrowedInterface: BooksClickBorrowedInterface,
    //Add userRole as switch to show or hide delete button
    private val userRole: String
    ): RecyclerView.Adapter<BooksRVAdapter.ViewHolder>()
{

    private val allBooks = ArrayList<Books>()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val booksTitleTextView: TextView = itemView.findViewById<TextView>(R.id.textView_id_books_title)
        val booksAuthorNameTextView: TextView = itemView.findViewById<TextView>(R.id.textView_id_books_author_name)
        val booksDescriptionTextView: TextView = itemView.findViewById<TextView>(R.id.textView_id_books_description)
        val booksCategoryTextView: TextView = itemView.findViewById<TextView>(R.id.textView_id_books_category)
        val booksQuantityTextView: TextView = itemView.findViewById<TextView>(R.id.textView_id_books_quantity)
        val booksDeleteImageView: ImageView = itemView.findViewById<ImageView>(R.id.imageView_delete_btn)
        val booksBorrowImageView: ImageView = itemView.findViewById<ImageView>(R.id.imageView_borrow_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.books_rv_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
    return allBooks.size
    }

    fun updateList(newList:List<Books>){
        allBooks.clear()
        allBooks.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.booksTitleTextView.text = allBooks[position].bookName
        holder.booksAuthorNameTextView.text = allBooks[position].authorName
        holder.booksDescriptionTextView.text = allBooks[position].bookDescription
        holder.booksCategoryTextView.text = allBooks[position].category
        holder.booksQuantityTextView.text = allBooks[position].quantity

        //If user is student, hide delete button
        if (userRole == "Student") {
            holder.booksDeleteImageView.visibility = View.GONE
            holder.booksBorrowImageView.visibility = View.VISIBLE

        }
        holder.booksBorrowImageView.setOnClickListener {
            booksClickBorrowedInterface.onBorrowIconClick(allBooks[position])
        }
        //If user is librarian, enable delete and edit function
        if(userRole == "Librarian"){
            holder.booksDeleteImageView.visibility = View.VISIBLE
            holder.booksBorrowImageView.visibility = View.GONE

            holder.booksDeleteImageView.setOnClickListener {
                booksClickDeleteInterface.onDeleteIconClick(allBooks[position])
            }

            holder.itemView.setOnClickListener {
                booksClickInterface.onBooksClick(allBooks[position])
            }
        }


    }
}

interface BooksClickDeleteInterface{
    fun onDeleteIconClick(books: Books)
}

interface BooksClickInterface{
    fun onBooksClick(books: Books)
}

interface BooksClickBorrowedInterface {
    fun onBorrowIconClick(book: Books)
}