package cmps312.lab.bankingapp.ui.transfer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.ui.transfer.viewmodel.TransferViewModel
import kotlinx.android.synthetic.main.fragment_transfer_confirmation.*

class TransferConfirmationFragment : Fragment(R.layout.fragment_transfer_confirmation) {

    val transferViewModel: TransferViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var action = R.id.toHome

        beneficiaryNameTv.text = transferViewModel.newTransfer.beneficiaryName
        fromAccountNoTv.text = transferViewModel.newTransfer.fromAccountNo
        amountTv.text = transferViewModel.newTransfer.amount.toString()
        beneficiaryAccountNoTv.text = transferViewModel.newTransfer.beneficiaryAccountNo

        confirmationBtn.setOnClickListener {
        //  todo call the addTransfer()
            transferViewModel.addTransfer();
            findNavController().navigate(action)
        }

        cancelBtn.setOnClickListener {
            findNavController().navigate(action)
        }

    }
}