package com.example.navigationmoduleone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.DataBinderMapperImpl
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationmoduleone.databinding.FragmentSendCustomObjectArgumentBinding
import com.example.navigationmoduleone.model.User


class SendCustomObjectArgumentFragment : Fragment() {

    private lateinit var binding:FragmentSendCustomObjectArgumentBinding
    private lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_send_custom_object_argument, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.sendButton.setOnClickListener {
            val user = User(binding.userName.text.toString())
            val list = listOf<User>(user,user)
            //first parameter being sent is simple user object and second is list of user
            val action = SendCustomObjectArgumentFragmentDirections.actionSendCustomObjectArgumentFragmentToReceiveCustomObjectFragment(user,list.toTypedArray())
            navController.navigate(action)
        }
    }
}