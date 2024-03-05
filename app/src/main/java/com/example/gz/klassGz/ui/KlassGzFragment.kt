package com.example.gz.klassGz.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.playlistmaker.databinding.FragmentKlassGzBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class KlassGzFragment : Fragment() {
    private lateinit var binding: FragmentKlassGzBinding
    private val viewModel by viewModel<KlassGzViewModel>()
    var user =""
    var service = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentKlassGzBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user = requireArguments().getString("USER").toString()
        service = requireArguments().getString("SERVICE").toString()

        Log.d ("MAALMI_KlassFrag", "user= $user, service=$service")
    }

companion object {
    fun newInstance() = KlassGzFragment().apply {
        arguments = Bundle().apply {}
    }
    fun passArgs(user: String, service:String): Bundle = bundleOf("USER" to user, "SERVICE" to service)
}

}