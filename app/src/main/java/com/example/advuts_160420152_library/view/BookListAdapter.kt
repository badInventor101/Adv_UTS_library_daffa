package com.example.advuts_160420152_library.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advuts_160420152_library.R
import com.example.advuts_160420152_library.model.Book
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class BookListAdapter (val BookList:ArrayList<Book>)
    :RecyclerView.Adapter<BookListAdapter.BookViewHolder>(){
    class BookViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.book_list_item, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return BookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtName).text = BookList[position].name
        holder.view.findViewById<TextView>(R.id.txtAuthor).text = BookList[position].author
        holder.view.findViewById<Button>(R.id.btnDetail).setOnClickListener {
            val action = BookListFragmentDirections.actionBookDetail(BookList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }

        var imageview = holder.view.findViewById<ImageView>(R.id.imageView)
        var progress = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        Picasso.get().load(BookList[position].photoUrl.toString()).resize(400, 400).centerCrop().error(R.drawable.baseline_error_24)
            .into(imageview, object : Callback {
                override fun onSuccess() {
                    progress.visibility = View.GONE
                }

                override fun onError(e: Exception?) {

                }

            })
    }

    fun updateBookList(newBookList: ArrayList<Book>) {
        BookList.clear()
        BookList.addAll(newBookList)
        notifyDataSetChanged()
    }

}