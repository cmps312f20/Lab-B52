package cmps312.lab.bankingapp.ui.transfer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cmps312.lab.bankingapp.R
import kotlinx.android.synthetic.main.fragment_transfer.*

class TransferFragment : Fragment(R.layout.fragment_transfer) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initialize the transfer
//        fromAccountNoSP.adapter = ArrayAdapter<Account>(
//            view.context,
//            android.R.layout.simple_dropdown_item_1line, BankRepository.accounts // replace this with model
//        )

        nextBtn.setOnClickListener {
            val action = R.id.toSelectBeneficiary
            findNavController().navigate(action)
        }
    }
}