package cmps312.lab.beneficiaryapp_review.data.api

import cmps312.lab.beneficiaryapp_review.model.Beneficiary
import retrofit2.http.GET
import retrofit2.http.Path

interface BeneficiaryService {

    @GET("beneficiaries/{cid}")
    fun getBeneficiaries(@Path("cid") cid : Int) : List<Beneficiary>
}

/*
BASE URL https://cmps312banking.herokuapp.com/api/
GET Beneficiaries	beneficiaries/:cid	GET
ADD Beneficiary	beneficiaries/:cid	POST [Required cid in the URL]
UPDATE Beneficiary	beneficiaries/:cid	POST [Requires cid in the URL]
DELETE Beneficiary	beneficiaries/:cid/:accounNo	DELETE [Requires cid and accountNo in the URL]

 */