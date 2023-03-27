package com.abdosharaf.shoestore.fragments.addNewShoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.abdosharaf.shoestore.R

class AddNewShowFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val text = view?.findViewById<TextView>(R.id.tvAddNew)
        text?.setOnClickListener {
            findNavController().navigate(R.id.action_addNewShowFragment_to_shoeListFragment)
        }
        return inflater.inflate(R.layout.fragment_add_new_show, container, false)
    }
}