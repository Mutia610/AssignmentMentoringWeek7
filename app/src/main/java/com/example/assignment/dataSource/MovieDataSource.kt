package com.example.assignment.dataSource

import android.view.View
import androidx.paging.PageKeyedDataSource
import com.example.assignment.model.ResultsItem
import com.example.assignment.network.MovieService
import com.example.assignment.network.ResApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MovieDataSource: PageKeyedDataSource<Long,ResultsItem>(){

    var api : MovieService

    init {
        api = ResApi.resApi()
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ResultsItem>
    ) {

        api.getMovie("b64d761def5c00e40e6a36e0032741bf",1,params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                t ->
                t.results?.let { callback.onResult(it,null,2L) }
            },{

            })

    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
        api.getMovie("b64d761def5c00e40e6a36e0032741bf",params.key,params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    t ->
                t.results?.let { callback.onResult(it,params.key + 1L) }
            },{

            })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {

    }

}