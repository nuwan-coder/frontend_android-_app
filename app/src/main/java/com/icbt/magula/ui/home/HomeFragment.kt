package com.icbt.magula.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.icbt.magula.R
import com.icbt.magula.databinding.FragmentHomeBinding
import com.icbt.magula.ui.adapter.HomeRecyclerViewAdapter

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding:FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            homeViewModel = viewModel
        }

        val hotels = listOf("A","b","c","d","e","f","g","h","i")

        recyclerView = view.findViewById(R.id.home_recycler_view)
        recyclerView.adapter = HomeRecyclerViewAdapter(hotels)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }
}