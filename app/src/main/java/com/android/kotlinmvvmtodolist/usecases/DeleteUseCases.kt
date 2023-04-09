package com.android.kotlinmvvmtodolist.usecases

import android.app.Application
import com.android.kotlinmvvmtodolist.database.TaskDatabase
import com.android.kotlinmvvmtodolist.database.TaskEntry
import com.android.kotlinmvvmtodolist.repository.DataBaseRepository

class DeleteUseCases(application: Application) {
    private val taskDao = TaskDatabase.getDatabase(application).taskDao()
    private val repository: DataBaseRepository

    init {
        repository = DataBaseRepository(taskDao)
    }

    suspend fun delete(taskEntry: TaskEntry) {
        repository.deleteItem(taskEntry)

    }

}