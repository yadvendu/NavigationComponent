package com.example.navigationmoduleone.basicanddrawernavigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.navigationmoduleone.bottomnavigation.BottomNavigationActivity
import com.example.navigationmoduleone.R
import com.example.navigationmoduleone.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding
    val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textTwo.text = args.number.toString()

        binding.textTwo.setOnClickListener {
            val intent = Intent(requireActivity(), BottomNavigationActivity::class.java)
            startActivity(intent)
        }
    }
}