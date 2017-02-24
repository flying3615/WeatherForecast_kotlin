package com.liuyufei.assignment1.extensions

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by liuyufei on 23/02/17.
 */
object DelegatesExt {
    fun <T> notNullStringValue() = NotNullSingleValueVar<T>()
}

class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} " +
                "not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if(this.value==null) value
        else throw IllegalStateException("${property.name} already initialized")
    }

}
