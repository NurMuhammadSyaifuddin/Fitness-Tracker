package com.project.fitness.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.fitness.db.converters.BitmapConverter
import com.project.fitness.db.converters.CalendarConverter
import com.project.fitness.db.schedule.Schedule
import com.project.fitness.db.schedule.ScheduleDao
import com.project.fitness.db.training.Training
import com.project.fitness.db.training.TrainingDao

@Database(entities = [Schedule::class, Training::class], version = 1)
@TypeConverters(CalendarConverter::class, BitmapConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao
    abstract fun trainingDao(): TrainingDao

}