package cmps312.lab.bankingapp.data.repository

import cmps312.lab.bankingapp.data.api.BankService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object BankRepository {
    //the user logs in and we know his/her customer info/customer id
    val customerID = 10001

    private val contentType = "application/json".toMediaType()
    private val BASE_URL = "https://cmps312banking.herokuapp.com/api/"

    private val converterFactory
            = Json { ignoreUnknownKeys = true }.asConverterFactory(contentType)

    val bankService by lazy {
        Retrofit.Builder()
            .addConverterFactory(converterFactory)  //json to kotlin  vice versa
            .baseUrl(BASE_URL)
            .build()
            .create(BankService::class.java)
    }
}