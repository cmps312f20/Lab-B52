package cmps312.lab.bankingapp.ui.transfer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.model.Transfer
import cmps312.lab.bankingapp.ui.transfer.adapter.TransferListAdapter
import kotlinx.android.synthetic.main.fragment_transfer_list.*

//Todo 2: Rename it to transfer
class TransferListFragment : Fragment(R.layout.fragment_transfer_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val transferAdapter: TransferListAdapter
        transactionRV.apply {
            layoutManager = LinearLayoutManager(view.context)
            transferAdapter = TransferListAdapter(view.context, ::showDetails)
            adapter = transferAdapter
        }
    }

    private fun showDetails(transfer: Transfer) {
        var action = TransferListFragmentDirections.toTransactionDetails()
        findNavController().navigate(action)
    }
}