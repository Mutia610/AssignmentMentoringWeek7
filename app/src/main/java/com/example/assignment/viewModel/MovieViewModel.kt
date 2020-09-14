package com.example.assignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.assignment.dataSource.factory.MovieDataFactory
import com.example.assignment.model.ResultsItem
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MovieViewModel: ViewModel() {

    var exuxutor : Executor
    var resultData : LiveData<PagedList<ResultsItem>>

    init {
        exuxutor = Executors.newFixedThreadPool(5)

        var movieFactory = MovieDataFactory()

        var pageListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()

        resultData = LivePagedListBuilder(movieFactory,pageListConfig)
            .setFetchExecutor(exuxutor)
            .build()
    }

    fun getArticle() : LiveData<PagedList<ResultsItem>>{
        return resultData
    }
}