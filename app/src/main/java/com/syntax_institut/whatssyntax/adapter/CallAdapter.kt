package com.syntax_institut.whatssyntax.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Call
import com.syntax_institut.whatssyntax.databinding.ItemCallBinding

class CallAdapter(
    val context: Context,
    val dataset: List<Call>
): RecyclerView.Adapter<CallAdapter.CallViewHolder>() {

    inner class CallViewHolder(val binding: ItemCallBinding) :
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val binding = ItemCallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CallViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.tvCallName.text = item.contact.name

        holder.binding.tvCallTime.text = item.time

        holder.binding.ivCallBenutzerbild.setImageResource(item.contact.image)


        holder.binding.ivCallPfeil.setImageResource(
                if (item.incoming) {
                    if (item.accepted) {
                        R.drawable.icon_call_accepted
                    } else R.drawable.icon_call_missed
                } else if (item.accepted) {
                    holder.binding.ivCallPfeil.rotation = 180f
                    R.drawable.icon_call_accepted
                } else {
                    holder.binding.ivCallPfeil.rotation = 180f
                    R.drawable.icon_call_missed
                }

            )

        holder.binding.contactCard.setOnClickListener {
            val phoneNumber = item.contact.number
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            context.startActivity(intent)
        }





    }


}