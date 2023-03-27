package com.abdosharaf.shoestore.fragments.shoeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.abdosharaf.shoestore.R
import com.abdosharaf.shoestore.ShoeModel
import com.abdosharaf.shoestore.databinding.FragmentShoeListBinding
import com.abdosharaf.shoestore.databinding.ItemShoeBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)

        binding.btnAdd.setOnClickListener {
//            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToAddNewShowFragment())
            val view: ItemShoeBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_shoe, binding.list, false)
            view.shoe = ShoeModel("Nike air force", "45", "Test", "This is a new shoe")
            binding.list.addView(view.root)
        }

        return binding.root
    }
}