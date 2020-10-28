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

    fun getProjects(): LiveData<List<Project>> = todoDao.getProjects()
    suspend fun addProject(project: Project): Long = todoDao.addProject(project)
    suspend fun updateProject(project: Project) = todoDao.updateProject(project)
    suspend fun deleteProject(project: Project) = todoDao.deleteProject(project)
    fun getTodoListByProjectId(pid: Int): LiveData<List<Todo>> = todoDao.getTodoListByProjectId(pid)
    fun getTodo(id: Int): Todo = todoDao.getTodo(id)
    suspend fun addTodo(todo: Todo): Long = todoDao.addTodo(todo)
    suspend fun updateTodo(todo: Todo) = todoDao.updateTodo(todo)
    suspend fun deleteTodo(todo: Todo) = todoDao.deleteTodo(todo)
}
