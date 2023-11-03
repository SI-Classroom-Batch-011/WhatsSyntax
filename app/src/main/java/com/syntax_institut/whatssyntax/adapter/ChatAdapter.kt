package com.syntax_institut.whatssyntax.adapter

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.data.model.Chat
import com.syntax_institut.whatssyntax.databinding.FragmentChatDetailBinding
import com.syntax_institut.whatssyntax.databinding.ItemCallBinding
import com.syntax_institut.whatssyntax.databinding.ItemChatsBinding
import com.syntax_institut.whatssyntax.ui.ChatsFragment
import com.syntax_institut.whatssyntax.ui.ChatsFragmentDirections
import com.syntax_institut.whatssyntax.ui.MessagDetailFragment

class ChatAdapter(
    //val context: Context,
    val dataset: List<Chat>
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(val binding: ItemChatsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ItemChatsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.ivCallBenutzerbild.setImageResource(item.contact.image)
        holder.binding.tvCallName.text = item.contact.name
        holder.binding.tvCallTime.text = item.messages.last().text

        holder.binding.contactCard.setOnClickListener {
            holder.itemView.findNavController().navigate(
                ChatsFragmentDirections.actionChatsFragmentToMessagDetailFragment(position)
            )
        }
    }
}