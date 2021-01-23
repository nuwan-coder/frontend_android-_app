package com.icbt.magula.ui.home.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.icbt.magula.R

class RegistrationFragment : Fragment() {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.registration_fragment, container, false)

        val t:TextView = view.findViewById(R.id.textView1)

        viewModel.text.observe(viewLifecycleOwner, Observer {
            t.text = it.toString()
        })

        return view
    }

}