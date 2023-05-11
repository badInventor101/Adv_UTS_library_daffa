package com.example.advuts_160420152_library.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.advuts_160420152_library.R
import com.example.advuts_160420152_library.viewmodel.ListViewModel


class DateListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel // list modelnya
    private val dateListAdapter = DateListAdapter(arrayListOf()) // ada adapter karena menggunakan recyclerView
    // dan datanya adalah arraylist ( banyak )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        val recAut = view.findViewById<RecyclerView>(R.id.recViewDate)
        recAut.layoutManager = LinearLayoutManager(context)
        recAut.adapter = dateListAdapter

        observeViewModel()
    }

    fun observeViewModel() {   /// di lihat dan di amati
        viewModel.booksLD.observe(viewLifecycleOwner, Observer {
            dateListAdapter.updateDateList(it) // lari ke studentListAdapter, di update studentListnya
        })
    }


}