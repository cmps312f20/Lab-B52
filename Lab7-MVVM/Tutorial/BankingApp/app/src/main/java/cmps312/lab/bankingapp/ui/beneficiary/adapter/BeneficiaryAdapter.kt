package cmps312.lab.bankingapp.ui.beneficiary.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.model.Beneficiary
import kotlinx.android.synthetic.main.list_item_beneficiary.view.*

class BeneficiaryAdapter(
    private val context: Context,
    private val listener: (Beneficiary) -> Unit
) :
    RecyclerView.Adapter<BeneficiaryAdapter.TransactionViewHolder>() {
    lateinit var beneficiaries: List<Beneficiary>

    init {
        beneficiaries = listOf<Beneficiary>()
    }
    inner class TransactionViewHolder(val itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(beneficiary: Beneficiary) {
            itemView.beneficiaryNameTv.text = beneficiary.name
            itemView.beneficiaryAccountNoTv.text = beneficiary.accountNo

            itemView.setOnClickListener { listener(beneficiary) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        //todo convert to binding
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_beneficiary, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(beneficiaries[position])
    }

    override fun getItemCount() = beneficiaries.size

    fun updateList(beneficiaries: List<Beneficiary>) {
        this.beneficiaries = beneficiaries;
        notifyDataSetChanged()
    }

}