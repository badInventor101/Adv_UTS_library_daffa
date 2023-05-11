package com.example.advuts_160420152_library.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.advuts_160420152_library.R
import com.example.advuts_160420152_library.util.loadImage
import com.example.advuts_160420152_library.viewmodel.DetailViewModel
import com.google.android.material.textfield.TextInputEditText
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.w3c.dom.Text
import java.util.concurrent.TimeUnit


class BookDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel // list modelnya



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val book_id = BookDetailFragmentArgs.fromBundle(requireArguments()).bookId // mengambil parameter ID
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(book_id) // passingkan ID

        // dan akhirnya di observe datanya setelah di fetch dari DetailViewModel
        observeViewModel()

    }

    fun observeViewModel() {   /// di lihat dan di amati
        /// bisa juga di ambil datanya
        viewModel.bookLD.observe(viewLifecycleOwner, Observer {

            var student = it




            val title = view?.findViewById<TextView>(R.id.txtTitle)
            val aut = view?.findViewById<TextView>(R.id.txtAuth)
            val rat = view?.findViewById<TextView>(R.id.txtRat)
            val gen = view?.findViewById<TextView>(R.id.txtGenre)
            val lang = view?.findViewById<TextView>(R.id.txtLang)
            val rel = view?.findViewById<TextView>(R.id.txtReal)
            val des = view?.findViewById<TextView>(R.id.txtDesc)
            val prog = view?.findViewById<ProgressBar>(R.id.progressBar2)
            val imgV = view?.findViewById<ImageView>(R.id.imageView2)




            title?.setText(viewModel.bookLD.value?.name)
            aut?.setText(viewModel.bookLD.value?.author)
            rat?.setText(viewModel.bookLD.value?.ratings.toString())
            gen?.setText(viewModel.bookLD.value?.genre)
            lang?.setText(viewModel.bookLD.value?.language)
            des?.setText(viewModel.bookLD.value?.desc)
            rel?.setText(viewModel.bookLD.value?.release)
            imgV?.loadImage(viewModel.bookLD.value?.photoUrl, prog!!)
        })





    }


}