package com.example.navigationmoduleone

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.navigationmoduleone.databinding.FragmentReceiveCustomObjectBinding

class ReceiveCustomObjectFragment : Fragment() {

    private lateinit var binding: FragmentReceiveCustomObjectBinding
    private val args: ReceiveCustomObjectFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_receive_custom_object,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getting user object from args
        binding.userName.text = args.user.userName
        //getting user list from args
        Log.d("UserList",args.userList.toList().toString())
    }
}