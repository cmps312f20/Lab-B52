package cmps312.lab.bankingapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
class Beneficiary(
    val name: String,
    val accountNo: String) : Parcelable {
}
