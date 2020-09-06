package com.cmps312.covidtracker

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import java.io.File

object CovidStatRepository {
    var covidStats = listOf<CovidStat>()
    init {
        val data = File("data/covid-data.json").readText()
        covidStats = Json.decodeFromString(data)
    }

    fun totalCovidDeaths() = covidStats.sumBy { it?.totalDeaths ?: 0 }

    fun totalActiveCases(continent: String) =
            covidStats.filter { it.continent.equals(continent, true) }
                      .sumBy { it?.totalCases ?: 0 }

    fun countriesHavingHighestCases(count: Int) =
        covidStats.sortedByDescending { it.totalCases }
                  .take(count)
                  .associate {it.country to it.totalCases!!}

    fun countriesHavingLowestCases(count: Int) =
        covidStats.sortedBy { it.totalCases }
                  .take(count)
                  .associate {it.country to it.totalCases!!}

    fun neighborsCriticalCases(country: String) : Map<String, Int> {
        val region = covidStats.first { it.country.equals(country, true) }.region

        return covidStats.filter { it.region == region && it.country != country && it.criticalCases != null }
                         .sortedByDescending { it.population }
                         .associate { it.country to it.criticalCases!! }
    }

    fun regionsWithHighestRecovery(continent: String) =
            covidStats.filter { it.continent == continent && it.totalRecovered!=null }
                      .groupingBy { it.region }
                      .fold(0) { sum: Long, covidStat -> sum + covidStat.totalRecovered!! }
                      // Workaround as .take does not on a Map
                      .toList().take(3).toMap()

    fun countryWithLowestDeaths(continent: String) =
            covidStats.filter { it.continent == continent && it.totalDeaths != null }
                      .minByOrNull { it.totalDeaths!! }
}



