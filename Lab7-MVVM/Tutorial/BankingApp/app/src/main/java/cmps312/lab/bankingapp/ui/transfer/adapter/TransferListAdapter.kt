package cmps312.lab.bankingapp.ui.transfer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.databinding.ListItemTransferBinding
import cmps312.lab.bankingapp.model.Transfer
import kotlinx.android.synthetic.main.list_item_beneficiary.view.*
import kotlinx.android.synthetic.main.list_item_transfer.view.*
import kotlinx.android.synthetic.main.list_item_transfer.view.beneficiaryNameTv


class TransferListAdapter(private val context: Context, private val listener: (Transfer) -> Unit) :
    RecyclerView.Adapter<TransferListAdapter.TransactionViewHolder>() {
    lateinit var transfers: List<Transfer>

    init {
        transfers = listOf<Transfer>()
    }
    inner class TransactionViewHolder(val binding: ListItemTransferBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(transfer: Transfer) {  //data binding
            binding.transfer = transfer

            binding.root.setOnClickListener { listener(transfer) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding: ListItemTransferBinding = DataBindingUtil
            .inflate(
                LayoutInflater.from(context),
                R.layout.list_item_transfer,
                parent,
                false
            )
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) = holder.bind(transfers[position])

    override fun getItemCount() = transfers.size

    fun updateList(transfers: List<Transfer>) {
        this.transfers = transfers;
        notifyDataSetChanged()
    }
}