package com.project.fitness.repository

import com.project.fitness.db.schedule.Schedule
import com.project.fitness.db.schedule.ScheduleDao
import com.project.fitness.db.training.Training
import com.project.fitness.db.training.TrainingDao
import javax.inject.Inject

class Repository @Inject constructor(
    private val trainingDao: TrainingDao,
    private val scheduleDao: ScheduleDao
) {

    // Training
    suspend fun insertTraining(training: Training) = trainingDao.insert(training)
    suspend fun deleteTraining(training: Training) = trainingDao.delete(training)

    fun getTrainingByDate() = trainingDao.getTrainingsByDate()
    fun getTrainingBydate(dayInMs: Long,nextDayInMs: Long) = trainingDao.getTrainingsByDate(dayInMs, nextDayInMs)
    fun getTrainingByDistance() = trainingDao.getTrainingsByDistance()
    fun getTrainingByAvg() = trainingDao.getTrainingsByAvg()
    fun getTrainingByTime() = trainingDao.getTrainingsByTime()

    fun getTotalTime() = trainingDao.getTotalTime()
    fun getTotalDistance() = trainingDao.getTotalDistance()
    fun getTotalAvg() = trainingDao.getTotalAVG()

    // Schedule
    suspend fun insertSchedule(schedule: Schedule) = scheduleDao.insert(schedule)
    suspend fun deleteSchedule(schedule: Schedule) = scheduleDao.delete(schedule)

    fun getSchedules() = scheduleDao.getSchedules()

}