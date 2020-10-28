package cmps312.lab.todoapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cmps312.lab.todoapplication.data.local.entity.Project
import cmps312.lab.todoapplication.data.local.entity.Todo

@Database(entities = [Project::class, Todo::class], version=1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao() : TodoDao

    //we need the database [singleton]
    companion object{
        @Volatile
        private var database : TodoDatabase? = null
        private val DB_NAME = "project_todo.db"

        @Synchronized
        fun getDatabase(context : Context) : TodoDatabase{
            if(database == null){
                database = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase :: class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration().build()
            }
            return database as TodoDatabase
        }
    }

}