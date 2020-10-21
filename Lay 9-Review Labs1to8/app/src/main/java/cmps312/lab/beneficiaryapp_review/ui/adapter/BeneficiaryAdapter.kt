package cmps312.lab.beneficiaryapp_review.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cmps312.lab.beneficiaryapp_review.R
import cmps312.lab.beneficiaryapp_review.databinding.BeneficiaryListItemBinding
import cmps312.lab.beneficiaryapp_review.model.Beneficiary

class BeneficiaryAdapter(val deleteBeneficiary: (Beneficiary) -> Unit) :
    RecyclerView.Adapter<BeneficiaryAdapter.BeneficiaryViewHolder>() {
    var beneficiaries = listOf<Beneficiary>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class BeneficiaryViewHolder(private val binding: BeneficiaryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(beneficiary: Beneficiary) {
            binding.beneficiary = beneficiary
            binding.deleteBenBtn.setOnClickListener { deleteBeneficiary(beneficiary) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeneficiaryViewHolder {
        val binding: BeneficiaryListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.beneficiary_list_item,
            parent,
            false
        )
        return BeneficiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeneficiaryViewHolder, position: Int) =
        holder.bind(beneficiaries[position])

    override fun getItemCount() = beneficiaries.size

}