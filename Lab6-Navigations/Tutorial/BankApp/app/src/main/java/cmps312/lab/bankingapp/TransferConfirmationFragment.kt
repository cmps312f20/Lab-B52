package cmps312.lab.bankingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_transfer_confirmation.*


class TransferConfirmationFragment : Fragment(R.layout.fragment_transfer_confirmation) {

    val args: TransferConfirmationFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            senderNameTv.text = args.transaction.senderName
        }
    }
}