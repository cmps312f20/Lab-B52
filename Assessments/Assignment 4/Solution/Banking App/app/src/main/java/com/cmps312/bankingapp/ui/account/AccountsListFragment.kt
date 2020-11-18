package com.cmps312.bankingapp.ui.account

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmps312.bankingapp.R
import com.cmps312.bankingapp.data.local.entity.Account
import com.cmps312.bankingapp.ui.account.adapter.AccountAdapter
import com.cmps312.bankingapp.ui.sharedViewModel.AccountViewModel
import kotlinx.android.synthetic.main.fragment_accounts_list.*

class AccountsListFragment : Fragment(R.layout.fragment_accounts_list) {
    private val accountViewModel: AccountViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accountAdapter = AccountAdapter(::deleteAccountListener, ::editAccountListener)
        accountsRv.apply {
            adapter = accountAdapter
            layoutManager = LinearLayoutManager(context)
        }

        addFab.setOnClickListener {
            accountViewModel.isEdit = false
            findNavController().navigate(R.id.action_accountsListFragment_to_addAccountFragment)
        }

        filterSP.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                accountViewModel.getAccountsByType(filterSP.selectedItem.toString())
                accountViewModel.accounts.observe(viewLifecycleOwner) {
                    accountAdapter.accounts = it
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        })

    }

    private fun deleteAccountListener(account: Account) {
        accountViewModel.deleteAccount(account)
    }

    private fun editAccountListener(account: Account) {
        accountViewModel.isEdit = true
        accountViewModel.selectedAccount = account
        findNavController().navigate(R.id.action_accountsListFragment_to_addAccountFragment)
    }
}