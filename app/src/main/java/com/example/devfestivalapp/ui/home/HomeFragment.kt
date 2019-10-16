package com.example.devfestivalapp.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_location.*
import androidx.core.os.HandlerCompat.postDelayed
import android.R
import android.content.Context
import android.content.pm.PackageManager
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*
import android.os.CountDownTimer

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.devfestivalapp.R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // post intent
        tweetButton.setOnClickListener(View.OnClickListener {
            sendTweet()
        })

    }

    private fun sendTweet() {
        val tweetIntent = Intent(Intent.ACTION_SEND)
        tweetIntent.putExtra(Intent.EXTRA_TEXT, "#DevFest2019, #DevFestPortHarcourt")
        tweetIntent.type = "text/plain"

        val  Context = context
        val packageManager = Context!!.packageManager
        val resolveInfoList =
            packageManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY)

        var resolved = false
        for (resolveInfo in resolveInfoList) {
            if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                tweetIntent.setClassName(
                    resolveInfo.activityInfo.packageName,
                    resolveInfo.activityInfo.name
                )
                resolved = true
                break
            }
        }
        if (resolved) {
            startActivity(tweetIntent)
        } else {
            Toast.makeText(context, "Twitter app isnt found", Toast.LENGTH_SHORT).show()
        }
    }


}