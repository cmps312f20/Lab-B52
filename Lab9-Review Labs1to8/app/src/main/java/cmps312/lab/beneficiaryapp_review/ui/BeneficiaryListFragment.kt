package cmps312.lab.beneficiaryapp_review.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cmps312.lab.beneficiaryapp_review.R
import cmps312.lab.beneficiaryapp_review.model.Beneficiary
import cmps312.lab.beneficiaryapp_review.ui.adapter.BeneficiaryAdapter
import cmps312.lab.beneficiaryapp_review.ui.viewmodel.BeneficiaryViewModel
import kotlinx.android.synthetic.main.fragment_beneficiary_list.*

class BeneficiaryListFragment : Fragment(R.layout.fragment_beneficiary_list) {

    val beneficiaryViewModel: BeneficiaryViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val beneficiaryAdapter = BeneficiaryAdapter(::deleteBeneficiary)

        beneficiaryRV.apply {
            adapter = beneficiaryAdapter
            layoutManager = LinearLayoutManager(context)
        }

        beneficiaryViewModel.beneficiaries.observe(viewLifecycleOwner) {
            beneficiaryAdapter.beneficiaries = it
        }

        addBtn.setOnClickListener { findNavController().navigate(R.id.toAddBeneficiaryFragment) }
    }

    fun deleteBeneficiary(beneficiary: Beneficiary) =
        beneficiaryViewModel.deleteBeneficiary(beneficiary)

}