package com.android.kotlinmvvmtodolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.android.kotlinmvvmtodolist.database.TaskEntry
import com.android.kotlinmvvmtodolist.usecases.AllUseCasesRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class TaskViewModel (application: Application) : AndroidViewModel(application) {

    private val allUseCasesRoom: AllUseCasesRoom

    var getAllTasks: LiveData<List<TaskEntry>>
    var getAllDoneTasks: LiveData<List<TaskEntry>>
    var getAllPriorityTask : LiveData<List<TaskEntry>>
    var visibility: Boolean = false


    init {
        allUseCasesRoom = AllUseCasesRoom(application)
        getAllPriorityTask=allUseCasesRoom.getAllPriorityTask()
        getAllDoneTasks = allUseCasesRoom.getAllDone()
        getAllTasks = allUseCasesRoom.getList()

    }

    fun finishTask(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            allUseCasesRoom.finishTask(id)
        }
    }


    fun deleteRepeat() {
        viewModelScope.launch(Dispatchers.IO) {
            allUseCasesRoom.deleteRepeat()
        }
    }

    fun insert(taskEntry: TaskEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            allUseCasesRoom.insert(taskEntry)
        }
    }



    fun delete(taskEntry: TaskEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            allUseCasesRoom.delete(taskEntry)
        }
    }

    fun update(taskEntry: TaskEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            allUseCasesRoom.update(taskEntry)
        }
    }

}