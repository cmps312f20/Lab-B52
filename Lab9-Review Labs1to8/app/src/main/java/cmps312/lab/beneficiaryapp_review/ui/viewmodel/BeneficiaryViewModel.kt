package cmps312.lab.beneficiaryapp_review.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import cmps312.lab.beneficiaryapp_review.data.repository.BeneficiaryRepo
import cmps312.lab.beneficiaryapp_review.model.Beneficiary
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class BeneficiaryViewModel : ViewModel() {
    private var _beneficiaries = getBeneficiaries() as MutableLiveData

    val beneficiaries = _beneficiaries

    private fun getBeneficiaries() = liveData {
        emit(BeneficiaryRepo.getBeneficiaries())
    }

    fun deleteBeneficiary(beneficiary: Beneficiary) {
        viewModelScope.launch {
            val _message =
                async { BeneficiaryRepo.deleteBeneficiary(beneficiary.accountNo) }.await()
            Log.d("TAG", _message)
            _beneficiaries.value?.let {
                _beneficiaries.value = it - beneficiary
            }
        }

    }
    fun addBeneficiary(beneficiary: Beneficiary) {
        viewModelScope.launch {
            val addedBeneficiary = async { BeneficiaryRepo.addBeneficiary(beneficiary) }.await()
            _beneficiaries.value?.let {
                _beneficiaries.value = it + addedBeneficiary
            }
        }

    }
}

//solve the exam ->
//1 week [you lab time]