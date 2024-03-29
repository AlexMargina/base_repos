package com.example.playlistmaker.setting.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.playlistmaker.databinding.FragmentSettingsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment() : Fragment() {


    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<SettingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.theme.observe(viewLifecycleOwner) { checked ->
            binding.themeSwitcher.isChecked = checked
        }


        // слежение и изменение темы приложения
        binding.themeSwitcher.setOnCheckedChangeListener { _, checked ->
            viewModel.switchTheme(checked)
        }

        // ПОДЕЛИТЬСЯ
        binding.imageButtonShare.setOnClickListener {
            viewModel.shareApp()
        }

        //НАПИСАТЬ в ПОДДЕРЖКУ
        binding.imageButtonSupport.setOnClickListener {
            viewModel.writeInSupport()
        }

        //ПОЛЬЗОВАТЕЛЬСКОЕ СОГЛАШЕНИЕ
        binding.frameLayoutOfer.setOnClickListener {
            viewModel.openUserAgreement()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

