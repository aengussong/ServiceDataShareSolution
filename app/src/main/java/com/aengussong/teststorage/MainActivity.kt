package com.aengussong.teststorage

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
    }

    override fun onStart() {
        super.onStart()
        startService(Intent(this, ProviderService::class.java))
    }

    override fun onStop() {
        super.onStop()
        stopService(Intent(this, ProviderService::class.java))
    }

    private fun initViewModel() {
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getUpdates().observe(this, Observer {
            counter.text = it.toString()
        })
    }
}
