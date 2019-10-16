package com.example.devfestivalapp.ui.event

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devfestivalapp.R
import com.example.devfestivalapp.adapter.EventAdapter
import com.example.devfestivalapp.api.RetrofitClient
import com.example.devfestivalapp.model.Event
import com.example.devfestivalapp.model.EventLists
import kotlinx.android.synthetic.main.fragment_event.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventProgramFragment : Fragment() {

    private var eventList: ArrayList<Event>? = null
    private var pDialog: ProgressDialog? = null
    private var recyclerView: RecyclerView? = null
    private var eventAdapter: EventAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pDialog = ProgressDialog(activity)
        //pDialog!!.setMessage("Event Program.. Please remain awesome and wait...")
        pDialog!!.isIndeterminate = false
        pDialog!!.setCancelable(false)
        pDialog!!.show()

        getApiInfo()

    }

    private fun getApiInfo() {
        val api = RetrofitClient.getApiService()
        val call = api.getMyJSON()

        call.enqueue(object : Callback<EventLists> {
            override fun onResponse(
                call: Call<EventLists>,
                response: Response<EventLists>
            ) {
                //Dismiss Dialog
                pDialog!!.dismiss()

                if (response.isSuccessful) {

                    eventList = response.body()!!.get()
                    recyclerView = eventListRecyclerView
                    eventAdapter = EventAdapter(eventList)
                    val eLayoutManager = LinearLayoutManager(context)
                    recyclerView!!.layoutManager = eLayoutManager
                    recyclerView!!.itemAnimator = DefaultItemAnimator()
                    recyclerView!!.adapter = eventAdapter
                }
            }

            override fun onFailure(call: Call<EventLists>, t: Throwable) {
                pDialog!!.dismiss()
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show()
            }
        })
    }
}