package cmps312.lab.bankingapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
class Account(
    val type: String,
    val accountNo: String) : Parcelable {

    override fun toString(): String {
        return "$type - $accountNo"
    }
}
