package cmps312.lab.beneficiaryapp_review.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import cmps312.lab.beneficiaryapp_review.data.repository.BeneficiaryRepo
import cmps312.lab.beneficiaryapp_review.model.Beneficiary

class BeneficiaryViewModel : ViewModel() {
    private var _beneficiaries = getBeneficiaries() as MutableLiveData

    val beneficiaries = _beneficiaries

    private fun getBeneficiaries() = liveData {
        emit(BeneficiaryRepo.getBeneficiaries())
    }

    fun deleteBeneficiary(beneficiary: Beneficiary){
        _beneficiaries.value?.let {
            _beneficiaries.value =   it - beneficiary
        }
    }

    fun addBeneficiary(beneficiary: Beneficiary){
        _beneficiaries.value?.let {
            _beneficiaries.value =   it + beneficiary
        }
    }
}