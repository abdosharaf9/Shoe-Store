package com.abdosharaf.shoestore.fragments.shoeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.abdosharaf.shoestore.R
import com.abdosharaf.shoestore.viewModels.ShoeViewModel
import com.abdosharaf.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)

        // Go back if the user click cancel
        binding.tvCancel.setOnClickListener {
            findNavController().navigateUp()
        }

        // Take the data and check them before save the shoe
        binding.btnSave.setOnClickListener {
            val name = binding.etShoeName.text.toString()
            val company = binding.etCompany.text.toString()
            val size = binding.etShoeSize.text.toString()
            val description = binding.etShoeDescription.text.toString()

            if(checkForm(name, company, size, description)){
                Toast.makeText(requireContext(), getString(R.string.added_to_list), Toast.LENGTH_SHORT).show()
                viewModel.addShoe(name, company, size, description)
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), R.string.plz_fill_fields, Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun checkForm(name: String?, company: String?, size: String?, description: String?): Boolean {
        return !(name.isNullOrEmpty() || company.isNullOrEmpty() || size.isNullOrEmpty() || description.isNullOrEmpty())
    }
}