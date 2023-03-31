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
    val booksClickDeleteInterface: BooksClickDeleteInterface,
    val booksClickInterface: BooksClickInterface,
    //Add userRole as switch to show or hide delete button
    private val userRole: String
    ): RecyclerView.Adapter<BooksRVAdapter.ViewHolder>()
{

    private val allBooks = ArrayList<Books>()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val booksTitleTextView = itemView.findViewById<TextView>(R.id.textView_id_books_title)
        val booksAuthorNameTextView = itemView.findViewById<TextView>(R.id.textView_id_books_author_name)
        val booksDescriptionTextView = itemView.findViewById<TextView>(R.id.textView_id_books_description)
        val booksCategoryTextView = itemView.findViewById<TextView>(R.id.textView_id_books_category)
        val booksQuantityTextView = itemView.findViewById<TextView>(R.id.textView_id_books_quantity)
        val booksDeleteImageView = itemView.findViewById<ImageView>(R.id.imageView_delete_btn)
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
        holder.booksTitleTextView.setText(allBooks.get(position).bookName)
        holder.booksAuthorNameTextView.setText(allBooks.get(position).authorName)
        holder.booksDescriptionTextView.setText(allBooks.get(position).bookDescription)
        holder.booksCategoryTextView.setText(allBooks.get(position).category)
        holder.booksQuantityTextView.setText(allBooks.get(position).quantity)

        //If user is student, hide delete button
        if (userRole == "Student") {
            holder.booksDeleteImageView.visibility = View.GONE
        }
        //If user is librarian, enable delete and edit function
        if(userRole == "Librarian"){
            holder.booksDeleteImageView.setOnClickListener {
                booksClickDeleteInterface.onDeleteIconClick(allBooks.get(position))
            }

            holder.itemView.setOnClickListener {
                booksClickInterface.onBooksClick(allBooks.get(position))
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