package com.example.advuts_160420152_library.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advuts_160420152_library.R
import com.example.advuts_160420152_library.model.Book

class AuthorListAdapter(val AuthorList:ArrayList<Book>)
    : RecyclerView.Adapter<AuthorListAdapter.AuthorViewHolder>(){

    class AuthorViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list_item, parent, false)
//        for (item in GenreList){
//            if (genre_.contains(item.genre.toString())){
//
//            }
//            else{
//                genre_.add(item.genre.toString())
//            }
//        }
//        genre_.removeAt(0)
//        Log.v("sjs", genre_.toString());
//        Log.v("jancok", genre_.size.toString());
        return AuthorListAdapter.AuthorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return AuthorList.size
    }

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {
        holder.view.findViewById<Button>(R.id.btnItem).setText(AuthorList[position].author.toString())
        holder.view.findViewById<Button>(R.id.btnItem).setOnClickListener {
            val action = AuthorListFragmentDirections.actionAuthorToHome(AuthorList[position].author.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateAuthorList(newBookList: ArrayList<Book>) {
        AuthorList.clear()
        AuthorList.addAll(newBookList)
        notifyDataSetChanged()
    }
}