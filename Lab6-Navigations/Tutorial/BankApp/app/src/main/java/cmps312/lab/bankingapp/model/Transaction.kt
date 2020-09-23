package cmps312.lab.bankingapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Transaction() : Parcelable {
    var senderName: String? = null
    var senderAccountNo: String? = null
    var receiverName: String? = null
    var receiverAccountNo: String? = null
    var amount: Double = 0.0
}