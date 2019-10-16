package com.example.devfestivalapp.api

import com.example.devfestivalapp.model.EventLists
import retrofit2.Call
import retrofit2.http.GET


interface Api {

    @GET("/db.json")
    fun getMyJSON(): Call<EventLists>
}