package cmps312.lab.bankingapp.ui.transfer

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.model.Account
import cmps312.lab.bankingapp.model.Transfer
import cmps312.lab.bankingapp.reposiotry.BankRepository
import cmps312.lab.bankingapp.ui.transfer.viewmodel.TransferViewModel
import kotlinx.android.synthetic.main.fragment_transfer.*

class TransferFragment : Fragment(R.layout.fragment_transfer) {
    val transferViewModel : TransferViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initialize the transfer

        transferViewModel.newTransfer = Transfer();

        fromAccountNoSP.adapter = ArrayAdapter<Account>(
            view.context,
            android.R.layout.simple_dropdown_item_1line,
            transferViewModel.accounts
        )

        nextBtn.setOnClickListener {
            transferViewModel.newTransfer.fromAccountNo = fromAccountNoSP.selectedItem.toString()
            transferViewModel.newTransfer.amount = amountEt.text.toString().toDouble()

            val action = R.id.toSelectBeneficiary
            findNavController().navigate(action)
        }
    }
}