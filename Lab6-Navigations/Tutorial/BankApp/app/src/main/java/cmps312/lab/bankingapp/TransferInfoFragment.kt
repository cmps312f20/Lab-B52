package cmps312.lab.bankingapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_transfer_info.view.*

class TransferInfoFragment : Fragment(R.layout.fragment_transfer_info) {

    val args : TransferInfoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            val transaction = args.transaction
            nextBtn.setOnClickListener {
               transaction.receiverName = recieverNameEdt.text.toString()
               transaction.receiverAccountNo = recieverAccountNoEdt.text.toString()

                val action = TransferInfoFragmentDirections
                    .actionTransferInfoFragmentToTransferConfirmationFragment(transaction)

                findNavController().navigate(action)
            }

        }
    }
}