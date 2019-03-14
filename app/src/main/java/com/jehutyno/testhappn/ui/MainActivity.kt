package com.jehutyno.testhappn.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import com.jehutyno.testhappn.R

class MainActivity : AppCompatActivity() {

    private val navHost by lazy { findNavController(this, R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHost.navigate(R.id.articlesFragment)
    }

    override fun onSupportNavigateUp() =
        navHost.navigateUp()

}