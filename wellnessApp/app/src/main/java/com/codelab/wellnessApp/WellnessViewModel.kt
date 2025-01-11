package com.codelab.wellnessApp

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel: ViewModel(){
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTasks>
        get() = _tasks

    fun remove(item: WellnessTasks){
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTasks, checked: Boolean){
        _tasks.find {
            it.id == item.id
        } ?.let { task ->
           task.checked = checked
        }
    }
}

private fun getWellnessTasks() = List(30) {
        i -> WellnessTasks(i, "Task # $i")
}