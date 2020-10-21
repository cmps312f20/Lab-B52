package cmps312.lab.beneficiaryapp_review.model

import kotlinx.serialization.Serializable

@Serializable
data class Beneficiary(var name : String="", var accountNo: String="", var cid: Int=0, var id : String ="")
