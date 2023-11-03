package com.syntax_institut.whatssyntax.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syntax_institut.whatssyntax.MainActivity
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.databinding.FragmentSettingsBinding
import com.syntax_institut.whatssyntax.adapter.StatusAdapter
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.data.model.Profile
import com.syntax_institut.whatssyntax.databinding.FragmentStatusBinding

class SettingsFragment: Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val mainActivity = activity as MainActivity
        val personNeu = mainActivity.datasurceKlein.getContacts().toMutableList()

        binding.tvMyName.text = Datasource().getProfile().name
        binding.tvMyNummer.text = Datasource().getProfile().number

        val datasource = Datasource()

        binding.btnSettingsSave.setOnClickListener {
            val name = binding.txSettingsName.text.toString()
            val nummer = binding.txTettingsTelefonnummer.text.toString()

            datasource.setProfile(Profile(name, nummer, R.drawable.pp_01))

            val profile = datasource.getProfile()
            binding.tvMyName.text = profile.name
            binding.tvMyNummer.text = profile.number
        }

    }


}