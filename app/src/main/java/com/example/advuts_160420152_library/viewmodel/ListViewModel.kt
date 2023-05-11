package com.example.advuts_160420152_library.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.advuts_160420152_library.model.Book

class ListViewModel(application: Application): AndroidViewModel(application) {
    val booksLD = MutableLiveData<ArrayList<Book>>()
    var bookD = ArrayList<Book>()
    val bookLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()


    fun refresh() {
        booksLD.value = arrayListOf(
            Book("1","This Book Loves You","Felix Arvid",3.8, "Humor", "Swedish", "2015", "https://m.media-amazon.com/images/I/71vmpcJWq7L._AC_UF1000,1000_QL80_.jpg", "Den här boken älskar dig (på engelska: This Book Loves You) är en bok från 2015 av svenska youtubern Felix 'PewDiePie' Kjellberg. Boken är en parodi på självhjälpsböcker med inspirerande citat och bilder. Den är ursprungligen på engelska och har översatts till bland annat franska, ryska, svenska, spanska, tyska."),
            Book("2","Catching Fire","Suzanne Collins",4.2,"Dystopian", "English", "2009", "https://upload.wikimedia.org/wikipedia/en/a/a2/Catching_Fire_%28Suzanne_Collins_novel_-_cover_art%29.jpg", "Catching Fire is a 2009 dystopian fiction young adult novel by the American novelist Suzanne Collins, the second book in The Hunger Games series. As the sequel to the 2008 bestseller The Hunger Games, it continues the story of Katniss Everdeen and the post-apocalyptic nation of Panem."),
            Book("3","The Stranger","Albert Camus",4.0,"Absurdist fiction", "French", "1942", "https://m.media-amazon.com/images/I/81GjCVSEDAL._AC_UF1000,1000_QL80_.jpg", "The Stranger ( français : L'Étranger [l‿e.tʁɑ̃.ʒe] ), également publié en anglais sous le nom de The Outsider , est une nouvelle de 1942 écrite par l'auteur français Albert Camus . Premier des romans de Camus publiés de son vivant, l'histoire suit Meursault, un colon indifférent en Algérie française, qui, quelques semaines après les funérailles de sa mère, tue un Arabe anonyme à Alger. L'histoire est divisée en deux parties, présentant le récit à la première personne de Meursault avant et après le meurtre."),
            Book("4","Filosofi kopi","Dewi Lestari",3.9,"Comics", "Bahasa", "2006", "https://inc.mizanstore.com/aassets/img/com_cart/produk/bt-504--.jpg", "Filosofi Kopi adalah sebuah buku fiksi karya Dewi Lestari yang akrab dipanggil dengan nama Dee. Selain Filosofi Kopi, karya lain Dee adalah Supernova, Rectoverso, dan Perahu Kertas.[1] Melalui buku Filosofi Kopi ini, Dee ingin menghadirkan bagaimana perjuangan seorang yang memiliki hobi terhadap kopi dan memaknai kopi dari sudut pandang kehidupan. Buku ini dianugerahi sebagai karya sastra terbaik tahun 2006 oleh majalah Tempo. Pada tahun yang sama, Filosofi Kopi juga berhasil dinobatkan menjadi 5 Besar Khatulistiwa Award kategori fiksi."),
            Book("5","Convenience Store Woman","Sayaka Murata",4.3,"Fiction", "Japanese", "2016", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1523623053i/38357895.jpg", "コンビニの女 (日本語: コンビニ人間、ヘップバーン: コンビニ人間) は、日本の作家、村田紗也加による 2016 年の小説です。 日本の生活の一部となっている身近なコンビニエンスストアの雰囲気を捉えています。 この小説は2016年に芥川賞を受賞した[4]。 執筆の傍ら、村田さんは自身の経験をもとに小説を書き、週に3回コンビニで働いていた。 文学会2016年6月号に初出[5]、2016年7月に文藝春秋より単行本化。"),

            )


        bookLoadErrorLD.value = false
        loadingLD.value = false
    }


    fun refresh_par(par_id: String="def"){
        var bookD_aft = ArrayList<Book>()

        var index_ = mutableListOf<Int>() // tempat INDEX
        var counter_ = 0

        bookD = arrayListOf(
            Book("1","This Book Loves You","Felix Arvid",3.8, "Humor", "Swedish", "2015", "https://m.media-amazon.com/images/I/71vmpcJWq7L._AC_UF1000,1000_QL80_.jpg", "Den här boken älskar dig (på engelska: This Book Loves You) är en bok från 2015 av svenska youtubern Felix 'PewDiePie' Kjellberg. Boken är en parodi på självhjälpsböcker med inspirerande citat och bilder. Den är ursprungligen på engelska och har översatts till bland annat franska, ryska, svenska, spanska, tyska."),
            Book("2","Catching Fire","Suzanne Collins",4.2,"Dystopian", "English", "2009", "https://upload.wikimedia.org/wikipedia/en/a/a2/Catching_Fire_%28Suzanne_Collins_novel_-_cover_art%29.jpg", "Catching Fire is a 2009 dystopian fiction young adult novel by the American novelist Suzanne Collins, the second book in The Hunger Games series. As the sequel to the 2008 bestseller The Hunger Games, it continues the story of Katniss Everdeen and the post-apocalyptic nation of Panem."),
            Book("3","The Stranger","Albert Camus",4.0,"Absurdist fiction", "French", "1942", "https://m.media-amazon.com/images/I/81GjCVSEDAL._AC_UF1000,1000_QL80_.jpg", "The Stranger ( français : L'Étranger [l‿e.tʁɑ̃.ʒe] ), également publié en anglais sous le nom de The Outsider , est une nouvelle de 1942 écrite par l'auteur français Albert Camus . Premier des romans de Camus publiés de son vivant, l'histoire suit Meursault, un colon indifférent en Algérie française, qui, quelques semaines après les funérailles de sa mère, tue un Arabe anonyme à Alger. L'histoire est divisée en deux parties, présentant le récit à la première personne de Meursault avant et après le meurtre."),
            Book("4","Filosofi kopi","Dewi Lestari",3.9,"Comics", "Bahasa", "2006", "https://inc.mizanstore.com/aassets/img/com_cart/produk/bt-504--.jpg", "Filosofi Kopi adalah sebuah buku fiksi karya Dewi Lestari yang akrab dipanggil dengan nama Dee. Selain Filosofi Kopi, karya lain Dee adalah Supernova, Rectoverso, dan Perahu Kertas.[1] Melalui buku Filosofi Kopi ini, Dee ingin menghadirkan bagaimana perjuangan seorang yang memiliki hobi terhadap kopi dan memaknai kopi dari sudut pandang kehidupan. Buku ini dianugerahi sebagai karya sastra terbaik tahun 2006 oleh majalah Tempo. Pada tahun yang sama, Filosofi Kopi juga berhasil dinobatkan menjadi 5 Besar Khatulistiwa Award kategori fiksi."),
            Book("5","Convenience Store Woman","Sayaka Murata",4.3,"Fiction", "Japanese", "2016", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1523623053i/38357895.jpg", "コンビニの女 (日本語: コンビニ人間、ヘップバーン: コンビニ人間) は、日本の作家、村田紗也加による 2016 年の小説です。 日本の生活の一部となっている身近なコンビニエンスストアの雰囲気を捉えています。 この小説は2016年に芥川賞を受賞した[4]。 執筆の傍ら、村田さんは自身の経験をもとに小説を書き、週に3回コンビニで働いていた。 文学会2016年6月号に初出[5]、2016年7月に文藝春秋より単行本化。"),

            )


        // untuk mengetahui tempat index berdasarkan parameter yang di dapat, entah auth, rat, genre, lang
        for (item in bookD){
            if (item.author.toString() == par_id){
                index_.add(counter_)

            }
            if (item.ratings.toString() == par_id){
                index_.add(counter_)

            }
            if (item.genre.toString() == par_id){
                index_.add(counter_)

            }
            if (item.language.toString() == par_id){
                index_.add(counter_)

            }
            if (item.release.toString() == par_id){
                index_.add(counter_)

            }
            counter_++



        }

        // add data setelah filter
        for (index in index_){
            bookD_aft.add(bookD[index])

        }


        // akhir

        // di set data ke booksLD setelah di filter
        booksLD.value = bookD_aft

        bookLoadErrorLD.value = false
        loadingLD.value = false



    }




}



