package com.cmps312.covidstats.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class CovidStats(
    var id: Int,
    var country: String?,
    var continent: String?,
    var region: String?,
    var totalCases: Int?,
    var newCases: Int?,
    var totalDeaths: Int?,
    var newDeaths: Int?,
    var totalRecovered: Int?,
    var newRecovered: Int?,
    var activeCases: Int?,
    var criticalCases: Int?,
    var casesPer1M: Int?,
    var deathsPer1M: Int?,
    var totalTests: Int?,
    var testsPer1M: Int?,
    var population: Int?
)


fun main(args: Array<String>) {


    //reading from a file as text (String)
    var data = File("data/covid-data.json").readText();

    //convert the text into object
    //a place to save my covid stats
    var covidStats = listOf<CovidStats>();

    //convert the string to List
    covidStats = Json.decodeFromString(data)

//    covidStats.forEach { println(it.country) }
//    val q = covidStats.find { it.country == "Qatar" }
//    println("Total people recovered from qatar are ${q?.totalRecovered}")

    covidStats.fold(0){acc: Int, covidStats: CovidStats ->  }


}