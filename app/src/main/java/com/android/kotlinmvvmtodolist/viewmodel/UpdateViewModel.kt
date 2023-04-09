package com.android.kotlinmvvmtodolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.android.kotlinmvvmtodolist.database.TaskEntry
import com.android.kotlinmvvmtodolist.usecases.DeleteUseCases
import com.android.kotlinmvvmtodolist.usecases.UpdateUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateViewModel(application: Application) : AndroidViewModel(application) {

    private val updateUseCases: UpdateUseCases
    private val deleteUseCases: DeleteUseCases

    init {
        updateUseCases = UpdateUseCases(application)
        deleteUseCases = DeleteUseCases(application)
    }

    fun delete(taskEntry: TaskEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteUseCases.delete(taskEntry)
        }
    }


    fun update(
        ids: Int,
        task_str: String,
        important: String,
        deadline: Long,
        createdAt: Long,
        s: String,
        dateNow: Long,
        b: Boolean,
        id: String,
        toString: String
    ) {
        val taskEntry = TaskEntry(
            ids,
            text = task_str,
            importance = important,
            deadline = deadline,
            created_at = createdAt,
            color = "",
            changed_at = dateNow,
            done = false,
            id = id,
            last_updated_by = toString
        )
        viewModelScope.launch(Dispatchers.IO) {
            updateUseCases.update(taskEntry)
        }
    }

}