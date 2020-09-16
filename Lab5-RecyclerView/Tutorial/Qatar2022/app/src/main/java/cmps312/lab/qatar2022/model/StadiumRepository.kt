package cmps312.lab.qatar2022.model

import android.content.Context


//reading the data from the json and converting to list
object StadiumRepository {
    val stadiums = listOf<Stadium>();

    fun initStadiums(context: Context){
        val data = context.assets
            .open("stadiums.json")
            .bufferedReader()
            .use { it.readText() }
    }
}