package com.abdosharaf.shoestore.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.abdosharaf.shoestore.R
import com.abdosharaf.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Check the user data before go the welcome screen
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if(checkForm(email, password)) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            } else{
                Toast.makeText(
                    requireContext(),
                    getString(R.string.plz_fill_fields),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Check the user data before go the welcome screen
        binding.tvSignup.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if(checkForm(email, password)) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            } else{
                Toast.makeText(
                    requireContext(),
                    getString(R.string.plz_fill_fields),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root
    }

    private fun checkForm(email: String?, password: String?): Boolean {
        return !(email.isNullOrEmpty() || password.isNullOrEmpty())
    }

    // Clear the inputs after close the screen
    override fun onStop() {
        super.onStop()
        binding.etEmail.setText("")
        binding.etPassword.setText("")
    }
}