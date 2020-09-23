package cmps312.lab.bankingapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

class TransferInfoFragment : Fragment(R.layout.fragment_transfer_info) {

    val args : TransferInfoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            Log.d("TAG", "onViewCreated: " + args.transaction.senderName)
        }
    }
}