package com.liuyufei.assignment1

import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.liuyufei.assignment1.domain.Forecast
import com.liuyufei.assignment1.domain.ForecastList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import kotlin.properties.Delegates

/**
 * Created by liuyufei on 22/02/17.
 */
class ForecastListAdapter(val weekForecast:ForecastList,val itemClick:(Forecast)->Unit): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view,itemClick)
    }


    class ViewHolder(view: View, val itemClick: (Forecast)->Unit): RecyclerView.ViewHolder(view){

        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }

}