package com.cmps312.covidtracker

fun main() {
    CovidStatRepository.apply {
        println("> World COVID deaths: ${totalCovidDeaths()}")

        val continent = "Asia"
        println("\n> Total active cases is $continent: ${totalActiveCases(continent)}")

        println("\n> Countries having the lowest COVID cases")
        countriesHavingLowestCases(5).forEach {
            println("%-25s: %,15d".format(it.key, it.value))
        }

        println("\n> Countries having the highest COVID cases")
        countriesHavingHighestCases(5).forEach {
            println("%-20s: %,15d".format(it.key, it.value))
        }

        val country = "Qatar"
        println("\n> Critical cases of $country neighbours")
        neighborsCriticalCases(country).forEach {
            println("%-20s: %,15d".format(it.key, it.value))
        }


        println("\n> Regions with the highest recovery in $continent")
        regionsWithHighestRecovery(continent).forEach {
            println("%-20s: %,15d".format(it.key, it.value))
        }

        println("\n> Country with the lowest deaths in $continent")
        countryWithLowestDeaths(continent)?.also { println("${it.country} had ${it.totalDeaths} deaths.") }
    }
}