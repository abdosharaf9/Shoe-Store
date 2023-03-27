package com.abdosharaf.shoestore.fragments.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.abdosharaf.shoestore.R

class ShoeListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val text = view?.findViewById<TextView>(R.id.tvShoeList)
        text?.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_addNewShowFragment)
        }
        return inflater.inflate(R.layout.fragment_shoe_list, container, false)
    }
}