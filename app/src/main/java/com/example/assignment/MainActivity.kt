package com.example.assignment

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.assignment.adapter.MovieListAdapter
import com.example.assignment.viewModel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var viewModel : MovieViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel?.getArticle()


        viewModel?.resultData?.observe(this, Observer {
            val adapter = MovieListAdapter()
            adapter.submitList(it)
            listMovie.adapter = adapter
        })
    }
}