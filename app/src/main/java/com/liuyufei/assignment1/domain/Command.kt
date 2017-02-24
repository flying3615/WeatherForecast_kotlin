package com.liuyufei.assignment1.domain

/**
 * Created by liuyufei on 22/02/17.
 */
interface Command<T> {
    fun execute():T
}