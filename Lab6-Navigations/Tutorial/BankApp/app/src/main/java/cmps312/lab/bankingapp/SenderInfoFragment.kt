package cmps312.lab.bankingapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import cmps312.lab.bankingapp.model.Transaction
import kotlinx.android.synthetic.main.fragment_sender_info.view.*

class SenderInfoFragment : Fragment(R.layout.fragment_sender_info) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val transaction = Transaction()
        view.apply {

            transaction.senderName = senderNameEdt.text.toString()
            transaction.senderAccountNo = senderAccountNoEdt.text.toString()
            transaction.amount = amountEdt.text.toString().toDouble()

            val action = SenderInfoFragmentDirections
                .actionSenderInfoFragmentToTransferInfoFragment(transaction)

            nextBtn.setOnClickListener{
                findNavController().navigate(action)
            }
        }
    }
}
