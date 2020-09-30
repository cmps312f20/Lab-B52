package cmps312.lab.bankingapp.ui.beneficiary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cmps312.lab.bankingapp.model.Beneficiary
import cmps312.lab.bankingapp.reposiotry.BankRepository

class SelectBeneficiaryViewModel(context: Application)
    : AndroidViewModel(context) {
    val _beneficiaries = MutableLiveData<MutableList<Beneficiary>>()

    init {
        BankRepository.initBeneficiaries(context)
        _beneficiaries.postValue(BankRepository.beneficiaries as MutableList<Beneficiary>)
    }

    fun beneficiaries() : LiveData<MutableList<Beneficiary>> =_beneficiaries
}