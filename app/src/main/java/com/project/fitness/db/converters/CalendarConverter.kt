package com.project.fitness.db.converters

import androidx.room.TypeConverter
import java.util.*

class CalendarConverter {

    @TypeConverter
    fun fromTimeStamp(value: Long?): Calendar? =
        value?.let { Calendar.getInstance().apply { timeInMillis = it } }

    @TypeConverter
    fun dateToTimeStamp(date: Calendar?): Long? =
        date?.timeInMillis

}