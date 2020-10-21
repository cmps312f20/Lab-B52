package cmps312.lab.beneficiaryapp_review.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cmps312.lab.beneficiaryapp_review.R
import cmps312.lab.beneficiaryapp_review.model.Beneficiary
import cmps312.lab.beneficiaryapp_review.ui.viewmodel.BeneficiaryViewModel
import kotlinx.android.synthetic.main.fragment_add_beneficiary.*

class AddBeneficiaryFragment : Fragment(R.layout.fragment_add_beneficiary) {
    val beneficiaryViewModel: BeneficiaryViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var beneficiary = Beneficiary()

        addBtn.setOnClickListener {
            beneficiary.apply {
                name = nameEdt.text.toString()
                accountNo = accountNoEdt.text.toString()
                cid = cidEdt.text.toString().toInt()
            }

            beneficiaryViewModel.addBeneficiary(beneficiary)
            activity?.onBackPressed()
        }

    }

}