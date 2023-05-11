package com.example.advuts_160420152_library.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advuts_160420152_library.R
import com.example.advuts_160420152_library.model.Book

class RatingListAdapter(val RatingList:ArrayList<Book>)
    : RecyclerView.Adapter<RatingListAdapter.RatingViewHolder>(){

    class RatingViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
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
        return RatingListAdapter.RatingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return RatingList.size
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        holder.view.findViewById<Button>(R.id.btnItem).setText(RatingList[position].ratings.toString())
        holder.view.findViewById<Button>(R.id.btnItem).setOnClickListener {
            val action = RatingListFragmentDirections.actionRatingToHome(RatingList[position].ratings.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateRatingList(newBookList: ArrayList<Book>) {
        RatingList.clear()
        RatingList.addAll(newBookList)
        notifyDataSetChanged()
    }
}