package com.example.navigationmoduleone.basicanddrawernavigation

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationmoduleone.R
import com.example.navigationmoduleone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfig: AppBarConfiguration
    lateinit var listener :NavController.OnDestinationChangedListener

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = findNavController(R.id.fragment)
        binding.navigationView.setupWithNavController(navController)
        appBarConfig = AppBarConfiguration(navController.graph,binding.drawerLayout)
        setupActionBarWithNavController(navController,appBarConfig)

        //determines what happens when we chooses the menu option from drawer layout
        listener = NavController.OnDestinationChangedListener{controller, destination, arguments ->
            when (destination.id){
                R.id.firstFragment ->{
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.colorPrimaryDark)))
                }

                R.id.secondFragment ->{
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.colorAccent)))
                }
            }
        }
    }

    //Initialize the nav listener on resume to work
    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }
}