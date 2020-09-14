package com.example.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieListAdapter : PagedListAdapter<ResultsItem,RecyclerView.ViewHolder>(ResultsItem().DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MovieHolder){
            holder.bindTo(getItem(position))
        }
    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindTo(item: ResultsItem?) {
            itemView.item_title.text = item?.name
            itemView.item_iso.text = item?.iso6391
            itemView.item_desc.text = item?.description
            Picasso.get().load("https://image.tmdb.org/t/p/w500${item?.posterPath}").into(itemView.item_image)
        }

    }

}


