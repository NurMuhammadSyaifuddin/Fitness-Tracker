package com.project.fitness.db.training

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.project.fitness.db.BaseDao

@Dao
interface TrainingDao: BaseDao<Training> {

    @Query("SELECT * FROM training ORDER BY startTime DESC")
    fun getTrainingsByDate(): LiveData<List<Training>>

    @Query("SELECT * FROM training WHERE startTime BETWEEN :dayInMs AND :nextDayInMs")
    fun getTrainingsByDate(dayInMs: Long, nextDayInMs: Long): LiveData<List<Training>>

    @Query("SELECT * FROM training ORDER BY avgInKMH DESC")
    fun getTrainingsByAvg(): LiveData<List<Training>>

    @Query("SELECT * FROM training ORDER BY duration DESC")
    fun getTrainingsByTime(): LiveData<List<Training>>

    @Query("SELECT * FROM training ORDER BY distance DESC")
    fun getTrainingsByDistance(): LiveData<List<Training>>

    @Query("SELECT SUM(duration) FROM training")
    fun getTotalTime(): LiveData<Long>

    @Query("SELECT SUM(distance) FROM training")
    fun getTotalDistance(): LiveData<Long>

    @Query("SELECT AVG(avgInKMH) FROM training")
    fun getTotalAVG(): LiveData<Long>

}