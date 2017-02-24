package com.liuyufei.assignment1.domain

import com.liuyufei.assignment1.Forecast
import com.liuyufei.assignment1.ForecastResult
import java.text.DateFormat
import java.util.*
import com.liuyufei.assignment1.domain.Forecast as ModelForecast

/**
 * Created by liuyufei on 22/02/17.
 */
class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult):ForecastList {
        return ForecastList(forecast.city.name,forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun  convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map{converForecastItemToDomain(it)}
    }

    private fun  converForecastItemToDomain(it: Forecast): ModelForecast {
        return ModelForecast(converDate(it.dt),it.weather[0].description,it.temp.max.toInt(),it.temp.min.toInt(),
                generateIconUrl(it.weather[0].icon))
    }

    private fun  generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"

    private fun converDate(dt: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(dt*1000)
    }
}