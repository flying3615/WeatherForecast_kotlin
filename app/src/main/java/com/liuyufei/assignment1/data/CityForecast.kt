package com.liuyufei.assignment1.data

import java.util.*

/**
 * Created by liuyufei on 24/02/17.
 */

class CityForecast(val map:MutableMap<String,Any?>,val dailyForecast:List<DayForecast>) {


    //delegate map will auto pop value to the fields
    var _id:Long by map
    var city:String by map
    var country:String by map

    constructor(id:Long,city:String,country:String,dailyForecast:List<DayForecast>):this(HashMap(),dailyForecast){
        this._id = id
        this.city = city
        this.country = country
    }

}

class DayForecast(map: MutableMap<String, Any?>) {
    var _id: Long by map
    var date: String by map
    var description: String by map
    var high: Int by map
    var low: Int by map
    var iconUrl: String by map
    var cityId: Long by map

    constructor(date: String, description: String, high: Int, low: Int,
                iconUrl: String, cityId: Long)
    : this(HashMap()) {
        this.date = date
        this.description = description
        this.high = high
        this.low = low
        this.iconUrl = iconUrl
        this.cityId = cityId
    }
}