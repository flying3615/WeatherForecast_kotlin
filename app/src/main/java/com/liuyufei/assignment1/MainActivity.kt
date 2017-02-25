package com.liuyufei.assignment1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import com.liuyufei.assignment1.domain.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //using kotlin extension to find element automatically by ID(forecastList) in layout file
        forecastList.layoutManager = LinearLayoutManager(this)

        async() {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result){forecast->toast(forecast.date)}
            }
        }

    }

    operator fun ViewGroup.get(position:Int): View = getChildAt(position)


}
