package com.liuyufei.assignment1.domain

/**
 * Created by liuyufei on 22/02/17.
 */
data class ForecastList(val id:Long, val city: String, val country: String,
                        val dailyForecast:List<Forecast>){


    operator fun get(position:Int) = dailyForecast[position]

    fun size() = dailyForecast.size
}

data class Forecast(val id:Long, val date: String, val description: String, val high: Int,
                    val low: Int,val iconUrl:String)
