package com.icbt.magula.ui.plan

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.icbt.magula.R
import com.icbt.magula.data.db.AppDatabase
import com.icbt.magula.data.network.MyApi
import com.icbt.magula.data.network.ServiceResponse
import com.icbt.magula.data.repository.UserRepository
import com.icbt.magula.databinding.LoginFragmentBinding
import com.icbt.magula.databinding.PlanFragmentBinding
import com.icbt.magula.ui.adapter.HomeRecyclerViewAdapter
import com.icbt.magula.ui.listner.RecyclerViewClickListner
import com.icbt.magula.ui.login.LoginViewModel
import com.icbt.magula.ui.login.LoginViewModelFactory

class PlanFragment : Fragment(), RecyclerViewClickListner {

    private lateinit var viewModel: PlanViewModel
    private lateinit var binding:PlanFragmentBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val api = MyApi();
        val db = AppDatabase(requireContext())
        val repository = UserRepository(api,db)

        val factory = PlanViewModelFactory(repository,viewLifecycleOwner,requireActivity(),requireContext())

        viewModel = ViewModelProviders.of(this,factory).get(PlanViewModel::class.java)
        binding = PlanFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sp: SharedPreferences =
                requireContext().getSharedPreferences("token", Context.MODE_PRIVATE)
        val sharedIdValue = sp.getString("token","defaultname")

        if(sharedIdValue.equals("defaultname")){
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("WARNING!!")
            builder.setMessage("First you need to login and come back here!!")
            builder.setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->
                findNavController().navigate(R.id.action_nav_plan_to_nav_home)
            }

            builder.setCancelable(false)
            builder.show()
        }else{

        }

        binding.apply {
            planViewModel = viewModel
            planFragment = this@PlanFragment
        }

        recyclerView = view.findViewById(R.id.plan_recycler_view)
    }

    fun onCancel(){
        findNavController().navigate(R.id.action_nav_plan_to_nav_home)
    }

    fun onFind(){
        viewModel.getSelectedServices()

        var images =
                listOf<Int>(R.drawable.a, R.drawable.c,R.drawable.d,R.drawable.f)


        viewModel.selectedServices.observe(viewLifecycleOwner, Observer { selectedServices ->
            recyclerView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = HomeRecyclerViewAdapter(selectedServices,images,this)
            }
        })

    }

    override fun onRecyclerViewItemClick(hotel: ServiceResponse) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(hotel.hotelName)
        builder.setMessage(
                "Address :\n${hotel.address}\n\n"
                        +"Email :\n${hotel.email}\n\n"
                        +"Contact No :\n${hotel.contactNo}\n\n"
                        +"Price per plate :\n${hotel.pricePerPlate}\n\n"
        )
        builder.setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->

        }

        builder.setCancelable(false)
        builder.show()
    }
}