package com.syntax_institut.whatssyntax.adapter

import android.content.Context
import android.graphics.ColorFilter
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.databinding.ItemStatusBinding
import com.syntax_institut.whatssyntax.ui.StatusFragmentDirections

class StatusAdapter(
    val context: Context,
    val dataset: List<Contact>
) : RecyclerView.Adapter<StatusAdapter.StatusViewHolder>() {


    inner class StatusViewHolder(val binding: ItemStatusBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        val binding = ItemStatusBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatusViewHolder(binding)
    }


    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        val item = dataset[position]


        holder.binding.tvStatusName.text = item.name
        holder.binding.ivStatusPerson.setImageResource(item.image)

        val saturateValue = 0.0f
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(saturateValue)

        val colorFilter: ColorFilter = ColorMatrixColorFilter(colorMatrix)



            if (item.status != null) {
                holder.binding.ivStatusPerson.clearColorFilter()
                holder.binding.contactCard.setOnClickListener {
                    holder.itemView.findNavController().navigate(
                        StatusFragmentDirections.actionStatusFragmentToStatusDetailsFrament(item.status!!.text)

                    )
                }

            } else {
                holder.binding.ivStatusPerson.colorFilter = colorFilter
            }


    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}