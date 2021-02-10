package com.example.navigationmoduleone

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.navigationmoduleone.databinding.FragmentBottomNavigationOneBinding
import com.example.navigationmoduleone.sendcustomobject.CustomObjectActivity


class BottomNavigationFragmentOne : Fragment() {

    private lateinit var binding: FragmentBottomNavigationOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentBottomNavigationOneBinding>(inflater,R.layout.fragment_bottom_navigation_one, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.text.setOnClickListener {
            val intent = Intent(requireActivity(),CustomObjectActivity::class.java)
            startActivity(intent)
        }
    }
}