package com.example.navigationmoduleone.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationmoduleone.R
import com.example.navigationmoduleone.databinding.ActivitySecondBinding

class BottomNavigationActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        navController = findNavController(R.id.fragment2)
        binding.bottomNavigation.setupWithNavController(navController)

        //To change the title of action bar on click of bottom navigation menu
        //To add custom name goto bottom_nav_graph and change label for each fragment
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.bottomNavigationFragmentOne,
                R.id.bottomNavigationFragmentTwo,
                R.id.bottomNavigationFragmentThree
            )
        )
        setupActionBarWithNavController(navController,appBarConfiguration)
    }
}