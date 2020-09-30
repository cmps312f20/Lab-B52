package cmps312.lab.bankingapp.ui.transfer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cmps312.lab.bankingapp.model.Transfer
import cmps312.lab.bankingapp.reposiotry.BankRepository

class TransferViewModel(context: Application) : AndroidViewModel(context) {
    private var _transfers = MutableLiveData<MutableList<Transfer>>() //null

    init {
        BankRepository.initTransfers(context)
        //event is raised [hey guys whoever was observing should get the new data]
        _transfers.postValue(BankRepository.transfers as MutableList<Transfer>)
    }

    fun transfers():LiveData<MutableList<Transfer>> = _transfers
}