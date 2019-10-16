package com.example.devfestivalapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EventLists {

    @SerializedName("transactions")
    @Expose
    private var withdrawals: ArrayList<Event>? = null

    fun get(): ArrayList<Event>? {
        return withdrawals
    }

    fun set(withdrawals: ArrayList<Event>) {
        this.withdrawals = withdrawals
    }
}