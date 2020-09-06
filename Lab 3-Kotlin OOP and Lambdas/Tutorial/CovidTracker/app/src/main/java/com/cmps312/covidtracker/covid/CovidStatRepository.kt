package com.cmps312.covidtracker.covid

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import java.io.File
import java.util.*

object CovidStatRepository {

    var covidStats = arrayListOf<CovidStat>()

    init {
        val data = File("data/covid-data.json").readText()
        covidStats = Json.decodeFromString(data.toString())
    }

    //some of the data is null that is why the if else
    fun totalCovidDeathAroundTheWorld() = covidStats.fold(0) { acc, covidStat ->
        return if (covidStat.totalDeaths == null) acc else acc + covidStat?.totalDeaths!!
    }

    fun totalActiveCasesInContent(continent: String) = covidStats
        .filter { it.continent == continent }
        .sumBy { if (it.totalCases != null) it.totalCases!! else 0 }

    fun topFiveCountriesWithCovidCases() = covidStats
        .sortedByDescending { it.totalCases }
        .take(5)
        .joinToString("\n") { "${it.country} : ${it.activeCases}" }

    fun lowestFiveCountriesWithCovidCases() = covidStats
        .sortedByDescending { it.totalCases }
        .takeLast(5)
        .joinToString(separator = "\n") { "${it.country} : ${it.activeCases}" }

    //    fun activeCasesInContent(continent: String) = covidStats.filter { it.continent == continent }
    //region
    fun criticalNeighborsCases(countryName: String): String {
        val country = covidStats
            .find { it.country == countryName }

        return covidStats.filter { it.region == country?.region && it.criticalCases!=null }.sortedByDescending { it.population }
            .joinToString { "${it.country} : ${it.criticalCases}" }

    }

    fun topThreeRegionsWithHighestRecoveryInContinent(continent: String): String {
        val countries = covidStats
            .filter { it.continent == continent && it.totalRecovered!=null && it.region!=null} //remove the nulls

        //group them by regions
        val regions = hashMapOf<String, Int>()
        countries.forEach {regions[it.region!!] = it.totalRecovered!!}

        return regions
            .toList()
            .sortedByDescending { (key, value) -> value }
            .take(3)
            .joinToString("\n") { (key, value) -> "$key : $value" }
    }

    fun countryWithLowestDeathInContinent(continent: String) =
        covidStats.filter { it.totalDeaths != null }        //to ignore the country with null total death
            .sortedByDescending { it.totalDeaths }
            .takeLast(1)


}



