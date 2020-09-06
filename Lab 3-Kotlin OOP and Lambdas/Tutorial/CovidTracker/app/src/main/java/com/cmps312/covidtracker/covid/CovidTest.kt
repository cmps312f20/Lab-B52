package com.cmps312.covidtracker.covid

fun main(args: Array<String>) {
    val line = "\n_________________________________________\n"
    CovidStatRepository.apply {
        println("Total Covid Death Around The World : ${totalCovidDeathAroundTheWorld()}\n")
        println("Lowest Five Countries With Covid Cases $line ${lowestFiveCountriesWithCovidCases()}\n")
        println("Total Covid Death Around The World $line ${topFiveCountriesWithCovidCases()}\n")
        println("Total Active Cases In Content Asia: ${totalActiveCasesInContent("Asia")}\n")
        println("Qatar Neighbours Critical Cases $line ${criticalNeighborsCases("Qatar")}\n")
        println("Top Regions With Highest Recovery In Continent $line ${criticalNeighborsCases("Qatar")}\n")
        println("Qatar Neighbours Critical Cases $line ${criticalNeighborsCases("Qatar")}\n")
        println(
            "Top Three Regions With Highest Recovery In Continent Asia $line ${
                topThreeRegionsWithHighestRecoveryInContinent("Asia")
            }"
        )
        println(
            "Country with the Lowest Death in Continent Asia $line ${
                countryWithLowestDeathInContinent("Asia")
            }"
        )
    }

}