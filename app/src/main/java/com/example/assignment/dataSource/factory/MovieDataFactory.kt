package com.example.assignment.dataSource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.assignment.dataSource.MovieDataSource
import com.example.assignment.model.ResultsItem

class MovieDataFactory : DataSource.Factory<Long,ResultsItem>() {

    var mutableLiveData : MutableLiveData<MovieDataSource>
    var movieDataSource : MovieDataSource

    init {
        mutableLiveData = MutableLiveData()
        movieDataSource = MovieDataSource()
    }

    override fun create(): DataSource<Long, ResultsItem> {
        mutableLiveData.postValue(movieDataSource)
        return movieDataSource
    }

    @JvmName("getMutableLiveData1")
    fun getMutableLiveData():MutableLiveData<MovieDataSource>{
        return mutableLiveData
    }
}