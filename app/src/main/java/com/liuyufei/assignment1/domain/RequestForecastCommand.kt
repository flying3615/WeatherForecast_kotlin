package com.liuyufei.assignment1.domain

import com.liuyufei.assignment1.ForecastRequest

/**
 * Created by liuyufei on 22/02/17.
 */
class RequestForecastCommand(private val zipCode:String):Command<ForecastList> {
    //get remote json and convert it to ForecastList
    override fun execute(): ForecastList {
        val forecastResult = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastResult.execute())
    }
}