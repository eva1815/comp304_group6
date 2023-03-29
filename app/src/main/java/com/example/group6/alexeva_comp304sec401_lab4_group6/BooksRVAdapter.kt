//package com.example.group6.alexeva_comp304sec401_lab4_group6
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books
//
//class BooksRVAdapter(
//    val context:Context,
//    val booksClickDeleteInterface: BooksClickDeleteInterface,
//    val booksClickInterface: BooksClickInterface
//    ): RecyclerView.Adapter<BooksRVAdapter.ViewHolder>()
//{
//
//    private val allBooks = ArrayList<Books>()
//
//    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val booksTextView = itemView.findViewById<TextView>(R.id.textView_id_books_fiction_one)
//     //   val booksDeleteImageView = itemView.findViewById<ImageView>(R.id.image_id_delete)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_fiction,parent,false)
//        return ViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//    return allBooks.size
//    }
//
//    fun updateList(newList:List<Books>){
//        allBooks.clear()
//        allBooks.addAll(newList)
//        notifyDataSetChanged()
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//       holder.booksTextView.setText(allBooks.get(position).bookName)
//        holder.booksDeleteImageView.setOnClickListener {
//            booksClickDeleteInterface.onDeleteIconClick(allBooks.get(position))
//        }
//
//        holder.itemView.setOnClickListener {
//            booksClickInterface.onBooksClick(allBooks.get(position))
//        }
//    }
//}
//
//interface BooksClickDeleteInterface{
//    fun onDeleteIconClick(books: Books)
//}
//
//interface BooksClickInterface{
//    fun onBooksClick(books: Books)
//}