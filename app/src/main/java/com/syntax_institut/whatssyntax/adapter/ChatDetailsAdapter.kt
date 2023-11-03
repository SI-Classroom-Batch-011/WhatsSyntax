package com.syntax_institut.whatssyntax.adapter

import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.syntax_institut.whatssyntax.data.model.Chat
import com.syntax_institut.whatssyntax.data.model.Message
import com.syntax_institut.whatssyntax.databinding.FragmentChatDetailBinding
import com.syntax_institut.whatssyntax.databinding.ItemChatIchBinding
import com.syntax_institut.whatssyntax.databinding.ItemChatKontaktBinding
import com.syntax_institut.whatssyntax.databinding.ItemChatsBinding


class ChatDetailsAdapter(
    val dataset: List<Message>

): RecyclerView.Adapter<ViewHolder>() {

    private val kontaktChat = 1
    private val ichChat = 2

    inner class KontaktViewHolder(val binding: ItemChatKontaktBinding): RecyclerView.ViewHolder(binding.root)
    inner class IchViewHolder(val  binding: ItemChatIchBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        val item = dataset[position]
        return if (item.incoming){
            kontaktChat
        } else{
            ichChat
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == kontaktChat) {
        val binding = ItemChatKontaktBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        KontaktViewHolder(binding)
        } else {
            val binding = ItemChatIchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            IchViewHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]

        if (holder is KontaktViewHolder) {
            holder.binding.tvKontaktChatText.text = item.text
        } else if(holder is IchViewHolder) {
            holder.binding.tvIchChatText.text = item.text
        }

        }
}


