package com.example.devfestivalapp.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_location.*
import android.content.Intent
import android.R
import android.net.Uri
import java.util.*


class LocationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.devfestivalapp.R.layout.fragment_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDirectionButton.setOnClickListener(View.OnClickListener {

            val addressString = "Ken Saro-Wiwa Innovation Hub"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://maps.google.co.in/maps?q=$addressString")
                startActivity(intent)

        })
    }
}