package cmps312.lab.bankingapp.ui.transfer.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import cmps312.lab.bankingapp.model.Account
import cmps312.lab.bankingapp.model.Transfer
import cmps312.lab.bankingapp.data.repository.BankRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TransferViewModel(appContext: Application) : AndroidViewModel(appContext) {
    private val TAG = "TransferViewModel"


    val accounts = liveData{
         emit(BankRepository.bankService.getAccount(BankRepository.customerID))
    }

    // Initialize using liveData builder
    private var _transfers = getTransfers() as MutableLiveData

    val transfers = _transfers as LiveData<List<Transfer>>

    private fun getTransfers(cid : Int = BankRepository.customerID) = liveData {
        emit(BankRepository.bankService.getTransfers(cid))
    }

    //when item is selected from TransferListFragment->TransferDetailsFragment
    lateinit var selectedTransfer: Transfer

    // used for holding the details of new Transfer - used instead of Nav Component nav args
    lateinit var newTransfer: Transfer


    fun setTransferFromDetails(fromAccount: String, amount: Double) {
        newTransfer = Transfer(fromAccount, amount)
    }

    fun setTransferBeneficiaryDetails(beneficiaryName: String, beneficiaryAccountNo: String) {
        newTransfer.beneficiaryName = beneficiaryName
        newTransfer.beneficiaryAccountNo = beneficiaryAccountNo
    }

    //used by TransferConfirmationFragment
    fun addTransfer(transfer: Transfer = newTransfer) {
        viewModelScope.launch {
            val responseTransfer = async { BankRepository.bankService.addTransfer(BankRepository.customerID, transfer)}.await()
            _transfers.value?.let {
                _transfers.value = it + responseTransfer
            }

        }
    }

    fun deleteTransfer(transfer: Transfer) {

        viewModelScope.launch {
            val response = async { BankRepository.bankService.deleteTransfer(transfer.cid, transfer.transferId)}.await()
            _transfers.value?.let {
                _transfers.value = it - transfer
            }
            Log.d(TAG, "deleteTransfer: $response")
        }
    }
}