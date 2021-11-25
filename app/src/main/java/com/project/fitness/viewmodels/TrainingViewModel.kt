package com.project.fitness.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.fitness.db.schedule.Schedule
import com.project.fitness.db.training.Training
import com.project.fitness.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrainingViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    fun insertTraining(training: Training) = viewModelScope.launch { repository.insertTraining(training) }
    fun deleteTraining(training: Training) = viewModelScope.launch { repository.deleteTraining(training) }

    fun getTrainingByDate() = repository.getTrainingByDate()
    fun getTrainingByDate(dayInMs: Long, nextDayInMs: Long) = repository.getTrainingBydate(dayInMs, nextDayInMs)
    fun getTrainingByDistance() = repository.getTrainingByDistance()
    fun getTrainingByAvg() = repository.getTrainingByAvg()
    fun getTrainingByTime() = repository.getTrainingByTime()

    fun getTotalTime() = repository.getTotalTime()
    fun getTotalDistance() = repository.getTotalDistance()
    fun getTotalAvg() = repository.getTotalAvg()

}