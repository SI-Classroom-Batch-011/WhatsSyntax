package com.syntax_institut.whatssyntax.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syntax_institut.whatssyntax.MainActivity
import com.syntax_institut.whatssyntax.adapter.ChatDetailsAdapter
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.databinding.FragmentChatDetailBinding
import com.syntax_institut.whatssyntax.data.model.Message

class MessagDetailFragment : Fragment() {

    private lateinit var binding: FragmentChatDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Greift auf die MainActivity zu um die werte dort zu speichern.
        val mainActivity = activity as MainActivity
        val chats = mainActivity.datasurceKlein.getChats()

        var position = 0
        arguments?.let {
            position = it.getInt("position")
        }

        binding.rvChat.adapter = ChatDetailsAdapter(chats[position].messages)

        binding.buttonSend.setOnClickListener {
            val contact = binding.textNachricht.text.toString()
            val text = Message(contact, false)
            chats[position].messages.add(text)
            binding.rvChat.adapter = ChatDetailsAdapter(chats[position].messages)

            binding.textNachricht.text?.clear()

        }
    }
}
