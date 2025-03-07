package com.example.viewpagefragmentdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewpagefragmentdemo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewPager()

    }

    private fun setUpViewPager(){
        val listOfFragments = listOf(HomeFragment(), ProfileFragment(), SettingsFragment())

        binding.viewPager.adapter = ViewPagerAdapter(
            listOfFragments,
            supportFragmentManager,
            lifecycle
        )


        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            tab.text = when (position) {
                0 -> "Home"
                1 -> "Profile"
                2 -> "Settings"
                else -> ""

            }
        }.attach()
    }


}