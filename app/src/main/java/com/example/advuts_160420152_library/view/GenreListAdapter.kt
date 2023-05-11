package com.example.advuts_160420152_library.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advuts_160420152_library.R
import com.example.advuts_160420152_library.model.Book

class GenreListAdapter(val GenreList:ArrayList<Book>)
    : RecyclerView.Adapter<GenreListAdapter.GenreViewHolder>() {

//    val genre_ : MutableList<String> = arrayListOf()
//    var genre_ = mutableListOf<String>("o")

    class GenreViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
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
        return GenreListAdapter.GenreViewHolder(view)
    }

    override fun getItemCount(): Int {
        return GenreList.size


    }



    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {

//        if (genre_.contains(GenreList[position].genre.toString())){
//            //holder.view.findViewById<Button>(R.id.btnItem).setText("janc")
//
//        }
//        else{
//            genre_.add(GenreList[position].genre.toString())
//            holder.view.findViewById<Button>(R.id.btnItem).setText(GenreList[position].genre.toString())
//        }
        holder.view.findViewById<Button>(R.id.btnItem).setText(GenreList[position].genre.toString())
        holder.view.findViewById<Button>(R.id.btnItem).setOnClickListener {
            val action = GenreListFragmentDirections.actionGenreToHome(GenreList[position].genre.toString())
            Navigation.findNavController(it).navigate(action)
        }

//        Log.v("jancok2", position.toString());

    }

    fun updateGenreList(newBookList: ArrayList<Book>) {
        GenreList.clear()
        GenreList.addAll(newBookList)
        notifyDataSetChanged()
    }
}