package com.example.playlistmaker.auth.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.playlistmaker.R
import com.example.playlistmaker.databinding.FragmentAuthBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment(): Fragment() {

    private lateinit var binding: FragmentAuthBinding
    private val viewModel by viewModel<AuthViewModel>()
    private val servicesGZ = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.stateLiveData.observe(viewLifecycleOwner) {
                state -> userIsExist(state)
        }
        binding.btAuth.setOnClickListener {
            val user = binding.edName.text.toString().trim()
            val pass = binding.edPass.text.toString().trim()
            viewModel.checkUser(user, pass)
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.fillData()
    }

    private fun userIsExist(state: AuthState) {
        when (state) {
            is AuthState.Empty -> {
                Toast.makeText(context, "Нет такого пользователя, проверьте интернет", Toast.LENGTH_LONG)
            }
            is AuthState.Content -> {
                servicesGZ.addAll(state.services)
                Log.d("MAALMI_Auth", "userIsExist($servicesGZ) ")
                //findNavController().navigate(R.id.playerFragment)
                if (servicesGZ.size>0 ) binding.textAuth.text = servicesGZ[0].toString()
            }
            else -> {
                Toast.makeText(context, "Проверьте пользователя и пароль", Toast.LENGTH_LONG)
            }
        }


    }


    companion object {
        fun newInstance() = AuthFragment().apply {
            arguments = Bundle().apply {}
        }
    }

}