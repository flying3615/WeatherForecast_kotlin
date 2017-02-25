package com.liuyufei.assignment1.data

import com.liuyufei.assignment1.data.db.DbDataMapper
import com.liuyufei.assignment1.domain.ForecastDataMapper
import org.jetbrains.anko.db.select
import java.util.*

/**
 * Created by liuyufei on 24/02/17.
 */
class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 val dataMapper: DbDataMapper = DbDataMapper()) {

    fun requestForecastByZipCode(zipcode:Long,date:Long) = forecastDbHelper.use{
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? "+" And ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipcode.toString(), date.toString())
                .parseList { DayForecast(HashMap()) }
    }
}