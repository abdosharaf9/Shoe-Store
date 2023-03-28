package com.abdosharaf.shoestore.fragments.shoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.abdosharaf.shoestore.utils.LangChanger.changeLang
import com.abdosharaf.shoestore.R
import com.abdosharaf.shoestore.models.ShoeModel
import com.abdosharaf.shoestore.viewModels.ShoeViewModel
import com.abdosharaf.shoestore.databinding.FragmentShoeListBinding
import com.abdosharaf.shoestore.databinding.ItemShoeBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentShoeListBinding.inflate(inflater, container, false)

        // Observe the list variable changes
        viewModel.shoesList.observe(viewLifecycleOwner) { shoesList ->

            // Remove all old views
            binding.list.removeAllViews()

            // Check if the empty state must be shown
            if (shoesList.isNullOrEmpty()) {
                binding.nsvList.isVisible = false
                binding.emptyState.isVisible = true
            } else {
                binding.nsvList.isVisible = true
                binding.emptyState.isVisible = false

                // Add a view for each show in the list
                shoesList.forEach { shoe ->
                    addShoe(shoe)
                }
            }
        }

        // Go to add shoe screen
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        // Set up the top options menu
        setHasOptionsMenu(true)

        return binding.root
    }

    // Inflate the single shoe layout and add it to the linear
    private fun addShoe(shoe: ShoeModel) {
        val view: ItemShoeBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_shoe, binding.list, false)
        view.shoe = shoe
        binding.list.addView(view.root)
    }

    // Clear the list after close the fragment
    override fun onDestroy() {
        super.onDestroy()
        viewModel.removeAll()
    }

    // Inflate the options menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.app_menu, menu)
    }

    // What to do if the options menu item is selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mi_logout -> findNavController().navigateUp()
            R.id.mi_language -> changeLang()
        }
        return super.onOptionsItemSelected(item)
    }
}