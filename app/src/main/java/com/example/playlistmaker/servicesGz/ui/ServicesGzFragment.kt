package com.example.playlistmaker.servicesGz.ui

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.ListFragment
import com.example.playlistmaker.databinding.FragmentServicesGzBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ServicesGzFragment(): ListFragment() {

    private lateinit var binding: FragmentServicesGzBinding
    private val viewModel by viewModel<ServicesGzViewModel>()
    private val servicesGZ = mutableListOf<String>()
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

                servicesGZ.addAll(state.services)
                servicesGZ.add("ЛФК5")
                servicesGZ.add("Админ5")
                servicesGZ.add(position.toString())
                servicesGZ.add (user.toString())
                servicesGZ.add("ЛФК4")
                servicesGZ.add("Админ4")
                servicesGZ.add(position.toString())
                servicesGZ.add (0,user.toString())
                servicesGZ.add(0, "ЛФК3")
                servicesGZ.add(0, "Админ3")
                servicesGZ.add(0, position.toString())
                servicesGZ.add (0,user.toString())
                servicesGZ.add(0, "ЛФК2")
                servicesGZ.add(0, "Админ2")
                servicesGZ.add(0, position.toString())
                servicesGZ.add (0,user.toString())
                servicesGZ.add(0, "ЛФК1")
                servicesGZ.add(0, "Админ1")


                servicesGZ.add(0, position.toString())
                servicesGZ.add (0,user.toString())

                val listAdapter = ArrayAdapter (binding.list.context, R.layout.simple_list_item_1, servicesGZ)
                setListAdapter(listAdapter)

                binding.list.adapter = listAdapter
                Log.d("MAALMI_Auth", "userIsExist($servicesGZ) ")
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