package cmps312.lab.bankingapp.ui.beneficiary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.model.Beneficiary
import cmps312.lab.bankingapp.ui.beneficiary.adapter.BeneficiaryAdapter
import cmps312.lab.bankingapp.ui.beneficiary.viewmodel.SelectBeneficiaryViewModel
import cmps312.lab.bankingapp.ui.transfer.viewmodel.TransferViewModel
import kotlinx.android.synthetic.main.fragment_select_beneficiary.*

class SelectBeneficiaryFragment : Fragment(R.layout.fragment_select_beneficiary) {

    //not shared model
    val selectBeneficiaryViewModel : SelectBeneficiaryViewModel by viewModels()
    //shared by all the fragments
    val transferViewModel : TransferViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var beneficiaryAdapter = BeneficiaryAdapter(view.context, ::updateBeneficiaryAndNavigateToConfirmation)

        selectBeneficiaryViewModel.beneficiaries().observe(viewLifecycleOwner){
            beneficiaryAdapter.updateList(it)
        }

        beneficiaryRV.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = beneficiaryAdapter
        }

    }

    private fun updateBeneficiaryAndNavigateToConfirmation(beneficiary: Beneficiary) {
        transferViewModel.newTransfer.beneficiaryName = beneficiary.name
        transferViewModel.newTransfer.beneficiaryAccountNo = beneficiary.accountNo
        val action = R.id.toTransferConfirmation
        findNavController().navigate(action)
    }

}