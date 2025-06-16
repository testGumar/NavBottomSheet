package com.app.nbapp

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.ui.AppBarConfiguration
import com.app.nbapp.databinding.ActivityMainBinding
import com.app.nbapp.fragments.HomeFragment
import com.app.nbapp.fragments.LibraryFragment
import com.app.nbapp.fragments.ShortsFragment
import com.app.nbapp.fragments.SubscriptionFragment


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.open_nav, R.string.close_nav)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.frame_layout, HomeFragment()).commit()
            binding.navView.setCheckedItem(R.id.nav_home)
        }
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null)
//                .setAnchorView(R.id.fab).show()
//        }
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setBackground(null)
        binding.bottomNavigationView.setOnItemSelectedListener({ item ->
            when (item.getItemId()) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.shorts -> replaceFragment(ShortsFragment())
                R.id.subscriptions -> replaceFragment(SubscriptionFragment())
                R.id.library -> replaceFragment(LibraryFragment())
            }
            true
        })

        binding.fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                showBottomDialog()
            }
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = getSupportFragmentManager()
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    private fun showBottomDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.layout_bottom_sheet)

        val videoLayout = dialog.findViewById<LinearLayout?>(R.id.layoutVideo)
        val shortsLayout = dialog.findViewById<LinearLayout?>(R.id.layoutShorts)
        val liveLayout = dialog.findViewById<LinearLayout?>(R.id.layoutLive)
        val cancelButton = dialog.findViewById<ImageView?>(R.id.cancelButton)

        videoLayout.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dialog.dismiss()
                Toast.makeText(this@MainActivity, "Upload a Video is clicked", Toast.LENGTH_SHORT)
                    .show()
            }
        })

        shortsLayout.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dialog.dismiss()
                Toast.makeText(this@MainActivity, "Create a short is Clicked", Toast.LENGTH_SHORT)
                    .show()
            }
        })

        liveLayout.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dialog.dismiss()
                Toast.makeText(this@MainActivity, "Go live is Clicked", Toast.LENGTH_SHORT).show()
            }
        })

        cancelButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                dialog.dismiss()
            }
        })

        dialog.show()
        dialog.getWindow()!!
            .setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.getWindow()!!.getAttributes().windowAnimations = R.style.DialogAnimation
        dialog.getWindow()!!.setGravity(Gravity.BOTTOM)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}