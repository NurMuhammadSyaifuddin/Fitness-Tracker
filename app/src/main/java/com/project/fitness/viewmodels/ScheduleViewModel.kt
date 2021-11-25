package com.project.fitness.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.fitness.db.schedule.Schedule
import com.project.fitness.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    fun insertSchedule(schedule: Schedule) = viewModelScope.launch { repository.insertSchedule(schedule) }
    fun deleteSchedule(schedule: Schedule) = viewModelScope.launch { repository.deleteSchedule(schedule) }

    fun getSchedules() = repository.getSchedules()
}