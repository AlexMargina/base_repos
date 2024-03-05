package com.example.gz.servicesGz.ui

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.findNavController
import com.example.gz.klassGz.ui.KlassGzFragment
import com.example.playlistmaker.databinding.FragmentServicesGzBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ServicesGzFragment(): ListFragment() {

    private lateinit var binding: FragmentServicesGzBinding
    private val viewModel by viewModel<ServicesGzViewModel>()
    private val servicesGZ = arrayListOf<String>()
    var user =""
    var position = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentServicesGzBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user = requireArguments().getString("USER").toString()
        position = requireArguments().getString("POSITION").toString()
        position?.let { viewModel.getServices(it) }

        viewModel.stateLiveData.observe(viewLifecycleOwner) {
                state -> displayServices(state)
        }
    }


    override fun onResume() {
        super.onResume()
        viewModel.getServices(position)
    }

    private fun displayServices(state: ServicesGzState) {
        when (state) {
            is ServicesGzState.Empty -> {
                Toast.makeText(context, "Нет такого пользователя, проверьте интернет", Toast.LENGTH_LONG).show()
            }
            is ServicesGzState.Content -> {
                servicesGZ.clear()
            for (service in state.services) {
                servicesGZ.add(service.usluga)
            }
                servicesGZ.add(0, "=== ВЫБЕРИТЕ УСЛУГУ ГЗ:  ")
                servicesGZ.add (0,user.toString())

                val listAdapter = ArrayAdapter (binding.list.context, R.layout.simple_list_item_1, servicesGZ)
                setListAdapter(listAdapter)

                binding.list.adapter = listAdapter

                binding.list.setOnItemClickListener { adapterView, view, i, l ->
                    if (i>1) {
                        findNavController().navigate (com.example.playlistmaker.R.id.klassFragment, KlassGzFragment.passArgs(user, servicesGZ[i]))
                    }
                }

                //findNavController().navigate(R.id.playerFragment)

            }
            else -> {
                Toast.makeText(context, "Проверьте пользователя и пароль", Toast.LENGTH_LONG).show()
            }
        }


    }

    companion object {
        fun newInstance() = ServicesGzFragment().apply {
            arguments = Bundle().apply {}
        }
        fun passArgs(user: String, position:String): Bundle = bundleOf("USER" to user, "POSITION" to position)
    }

}