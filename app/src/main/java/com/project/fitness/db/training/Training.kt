package com.project.fitness.db.training

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.project.fitness.utils.training.TrainingType
import java.util.*

@Entity(tableName = "training")
data class Training(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    var image: Bitmap? = null,
    val trainingType: TrainingType,
    val startTime: Calendar,
    val stopTime: Calendar,
    val distance: Double,
    val duration: Long,
    val avgInKMH: Double
){
    override fun toString(): String {
        val unit = if (trainingType == TrainingType.CYCLING) "kilpmeters" else "step"
        val detailString = if (trainingType == TrainingType.CYCLING) "$distance/1000" else "$distance"
        return "$trainingType on ${Date(startTime.timeInMillis)} until ${Date(stopTime.timeInMillis)}, achieved: $detailString $unit"
    }
}