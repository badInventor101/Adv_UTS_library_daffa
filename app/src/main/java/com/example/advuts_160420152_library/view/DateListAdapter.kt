package com.example.advuts_160420152_library.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advuts_160420152_library.R
import com.example.advuts_160420152_library.model.Book

class DateListAdapter(val DateList:ArrayList<Book>)
    : RecyclerView.Adapter<DateListAdapter.DateViewHolder>(){

    class DateViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
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
        return DateListAdapter.DateViewHolder(view)
    }

    override fun getItemCount(): Int {
        return DateList.size
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.view.findViewById<Button>(R.id.btnItem).setText(DateList[position].release.toString())
        holder.view.findViewById<Button>(R.id.btnItem).setOnClickListener {
            val action = DateListFragmentDirections.actionDateToHome(DateList[position].release.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateDateList(newBookList: ArrayList<Book>) {
        DateList.clear()
        DateList.addAll(newBookList)
        notifyDataSetChanged()
    }
}