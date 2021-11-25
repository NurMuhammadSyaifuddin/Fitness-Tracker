package com.project.fitness.db.schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.project.fitness.utils.training.RepeatType
import com.project.fitness.utils.training.TrainingType
import java.util.*

@Entity(tableName = "schedules")
data class Schedule(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var scheduleId: Int = 0,

    val trainingType: TrainingType,
    val repeatType: RepeatType,
    val nextInvocation: Calendar,
    val duration: Long,
    val target: Double,
    val runInBackground: Boolean
){
    override fun toString(): String = "$repeatType $trainingType on ${Date(nextInvocation.timeInMillis)}"
}
