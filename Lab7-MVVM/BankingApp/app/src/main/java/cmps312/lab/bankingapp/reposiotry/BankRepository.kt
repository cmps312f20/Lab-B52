package cmps312.lab.bankingapp.reposiotry

import android.content.Context
import cmps312.lab.bankingapp.model.Account
import cmps312.lab.bankingapp.model.Beneficiary
import cmps312.lab.bankingapp.model.Transfer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object BankRepository {
    var beneficiaries = listOf<Beneficiary>()
    var transfers = listOf<Transfer>()
    var accounts = listOf<Account>()

    private fun readData(filename: String, context: Context) = context.assets
        .open(filename)
        .bufferedReader().use {
            it.readText()
        }

    fun initTransfers(context: Context) {
        var data = readData("transfers.json", context)
        transfers = Json { ignoreUnknownKeys = true }
            .decodeFromString(data)
    }

    fun initBeneficiaries(context: Context) {
        var data = readData("beneficiaries.json", context)
        beneficiaries = Json { ignoreUnknownKeys = true }
            .decodeFromString(data)
    }

    fun initAccounts(context: Context) {
        var data = readData("accounts.json", context)
        accounts = Json { ignoreUnknownKeys = true }
            .decodeFromString(data)
    }

}