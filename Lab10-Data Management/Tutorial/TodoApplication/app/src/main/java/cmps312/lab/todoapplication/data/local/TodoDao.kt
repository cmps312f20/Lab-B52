package cmps312.lab.todoapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import cmps312.lab.todoapplication.data.local.entity.Project
import cmps312.lab.todoapplication.data.local.entity.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM Project")
    fun getProjects() : LiveData<List<Project>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProject(project: Project) : Long

    @Update
    suspend fun updateProject(project: Project)

    @Delete
    suspend fun deleteProject(project: Project)

    @Query("SELECT * FROM Todo WHERE pid = :pid")
    fun getTodoListByProjectId(pid : Int) : LiveData<List<Todo>>

    @Query("SELECT * FROM Todo WHERE id=:id")
    fun getTodo(id : Int) : Todo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodo(todo: Todo) : Long

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

}