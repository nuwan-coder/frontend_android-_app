package com.icbt.magula.ui.plan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.icbt.magula.R

class PlanFragment : Fragment() {

    private val viewModel: PlanViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.plan_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sp: SharedPreferences =
                activity?.getSharedPreferences("token", Context.MODE_PRIVATE)!!
        val sharedIdValue = sp.getString("token","defaultname")

        if(sharedIdValue == null){
            findNavController().navigate(R.id.action_nav_plan_to_nav_home)
        }else{
            Log.d("d","hello")
        }
    }
}