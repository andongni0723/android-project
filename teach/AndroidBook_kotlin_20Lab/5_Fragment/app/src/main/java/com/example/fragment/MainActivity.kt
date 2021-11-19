package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("main act", "onCreate")

        val adapter = ViewPagerAdapter(this) // Create the "FragmentPagerAdapter"
        findViewById<ViewPager2>(R.id.pagerMain).adapter = adapter // Line the Adapter, let Fragment has linking with ViewAdapter
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("main act", "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.e("main act", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("main act", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("main act", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("main act", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("main act", "onDestroy")
    }
}

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount() = 3

    // Callback the Fragment of correct position, decided display order for page
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> ThirdFragment()
        }
    }


}
