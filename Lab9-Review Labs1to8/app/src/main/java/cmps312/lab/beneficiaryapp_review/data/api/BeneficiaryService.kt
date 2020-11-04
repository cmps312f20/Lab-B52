package cmps312.lab.beneficiaryapp_review.data.api

import cmps312.lab.beneficiaryapp_review.model.Beneficiary
import retrofit2.http.*

interface BeneficiaryService {

    @GET("beneficiaries/{cid}")
    suspend fun getBeneficiaries(@Path("cid") cid: Int): List<Beneficiary>

    @DELETE("beneficiaries/{cid}/{accountNo}")
    suspend fun deleteBeneficiary(@Path("cid") cid : Int , @Path("accountNo") accountNo: String) : String

    @POST("beneficiaries/{cid}")
    suspend fun addBeneficiary(@Path("cid") cid : Int , @Body beneficiary: Beneficiary) : Beneficiary

}