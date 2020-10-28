package cmps312.lab.todoapplication.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cmps312.lab.todoapplication.data.local.TodoDatabase
import cmps312.lab.todoapplication.data.local.entity.Project
import cmps312.lab.todoapplication.data.local.entity.Todo

class TodoListRepo(private val context: Context) {

    private val todoDao by lazy {
        TodoDatabase.getDatabase(context).todoDao()
    }

    fun getProjects(): LiveData<List<Project>> {
        TODO("Not yet implemented")
    }

    suspend fun addProject(project: Project): Long {
        TODO("Not yet implemented")
    }

    suspend fun updateProject(project: Project) {
        TODO("Not yet implemented")
    }

    suspend fun deleteProject(project: Project) {
        TODO("Not yet implemented")
    }

    fun getTodoListByProjectId(pid: Int): LiveData<List<Todo>> {
        TODO("Not yet implemented")
    }

    fun getTodo(id: Int): Todo {
        TODO("Not yet implemented")
    }

    suspend fun addTodo(todo: Todo): Long {
        TODO("Not yet implemented")
    }

    suspend fun updateTodo(todo: Todo) {
        TODO("Not yet implemented")
    }

    suspend fun deleteTodo(todo: Todo) {
        TODO("Not yet implemented")
    }


}