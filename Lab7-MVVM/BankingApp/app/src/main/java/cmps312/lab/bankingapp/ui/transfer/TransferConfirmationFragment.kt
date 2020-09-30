package cmps312.lab.bankingapp.ui.transfer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cmps312.lab.bankingapp.R
import kotlinx.android.synthetic.main.fragment_transfer_confirmation.*

class TransferConfirmationFragment : Fragment(R.layout.fragment_transfer_confirmation) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var action = TransferConfirmationFragmentDirections.toHome()

        confirmationBtn.setOnClickListener {
        //  todo call the addTransfer()
            findNavController().navigate(action)
        }

        cancelBtn.setOnClickListener {
            findNavController().navigate(action)
        }

    }
}