package com.liuyufei.assignment1.ui

import android.app.Application
import com.liuyufei.assignment1.extensions.DelegatesExt

/**
 * Created by liuyufei on 23/02/17.
 */
class App:Application(){
    companion object{
        var instance:App by DelegatesExt.notNullStringValue()

    }

    override fun onCreate(){
        super.onCreate()
        instance = this
    }
}