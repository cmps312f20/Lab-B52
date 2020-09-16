package cmps312.lab.qatar2022.model

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


//reading the data from the json and converting to list
object StadiumRepository {
    var stadiums = listOf<Stadium>();

    fun initStadiums(context: Context){
        val data = context.assets
            .open("stadiums.json")
            .bufferedReader()
            .use { it.readText() }

        //change it to stadium list object
        stadiums = Json {ignoreUnknownKeys = true}
            .decodeFromString(data)//4 -> 2

    }

}