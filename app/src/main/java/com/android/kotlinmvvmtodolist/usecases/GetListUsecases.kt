package com.android.kotlinmvvmtodolist.usecases

import android.app.Application
import androidx.lifecycle.LiveData
import com.android.kotlinmvvmtodolist.database.TaskDatabase
import com.android.kotlinmvvmtodolist.database.TaskEntry
import com.android.kotlinmvvmtodolist.repository.DataBaseRepository

class GetListUsecases(application: Application) {
    private val taskDao = TaskDatabase.getDatabase(application).taskDao()
    private val repository: DataBaseRepository

    init {
        repository = DataBaseRepository(taskDao)
    }

    fun getDoneList(): LiveData<List<TaskEntry>> {
        return repository.getAllDone()
    }

    fun getList(): LiveData<List<TaskEntry>> {
        return repository.getAllTasks()
    }
    fun getAllPriorityTask(): LiveData<List<TaskEntry>>{
        return repository.getAllPriorityTasks()
    }

}