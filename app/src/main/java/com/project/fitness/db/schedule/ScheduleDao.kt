package com.project.fitness.db.schedule

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.project.fitness.db.BaseDao

@Dao
interface ScheduleDao: BaseDao<Schedule> {
    @Query("SELECT * FROM schedules")
    fun getSchedules(): LiveData<List<Schedule>>
}