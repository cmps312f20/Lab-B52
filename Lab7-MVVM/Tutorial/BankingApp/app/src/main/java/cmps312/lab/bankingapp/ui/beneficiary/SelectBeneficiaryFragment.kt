package cmps312.lab.bankingapp.ui.beneficiary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.model.Beneficiary
import cmps312.lab.bankingapp.ui.beneficiary.adapter.BeneficiaryAdapter
import kotlinx.android.synthetic.main.fragment_select_beneficiary.*

class SelectBeneficiaryFragment : Fragment(R.layout.fragment_select_beneficiary) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        beneficiaryRV.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = BeneficiaryAdapter(view.context, ::updateBeneficiaryAndNavigateToConfirmation)
        }

    }

    private fun updateBeneficiaryAndNavigateToConfirmation(beneficiary: Beneficiary) {

        val action = R.id.toTransferConfirmation
        findNavController().navigate(action)
    }

}