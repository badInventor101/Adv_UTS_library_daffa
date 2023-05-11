package com.example.advuts_160420152_library.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advuts_160420152_library.R
import com.example.advuts_160420152_library.model.Book

class LanguageListAdapter(val LanguageList:ArrayList<Book>)
    : RecyclerView.Adapter<LanguageListAdapter.LanguageViewHolder>(){

    class LanguageViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
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
        return LanguageListAdapter.LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return LanguageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.view.findViewById<Button>(R.id.btnItem).setText(LanguageList[position].language.toString())
        holder.view.findViewById<Button>(R.id.btnItem).setOnClickListener {
            val action = LanguageListFragmentDirections.actionLanguageToHome(LanguageList[position].language.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateLanguageList(newBookList: ArrayList<Book>) {
        LanguageList.clear()
        LanguageList.addAll(newBookList)
        notifyDataSetChanged()
    }
}