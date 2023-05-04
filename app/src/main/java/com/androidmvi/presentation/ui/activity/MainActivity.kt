package com.androidmvi.presentation.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.androidmvi.databinding.ActivityMainBinding
import com.androidmvi.presentation.ui.intent.main.MainActivityIntent
import com.androidmvi.presentation.ui.viewmodel.main.MainActivityViewModel
import com.androidmvi.presentation.ui.viewstate.main.MainActivityState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mMainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupAndHandleViewModelData()

        initClick()
    }

    private fun initClick() {
        binding.buttonLoadData.setOnClickListener {
            // Here we send the intent to the ViewModel to load data
            mMainActivityViewModel.processIntent(MainActivityIntent.LoadData)
        }
    }

    // Here we observe and handle all states from the ViewModel
    private fun setupAndHandleViewModelData() {
        mMainActivityViewModel.state.observe(this) { state ->
            when (state) {
                is MainActivityState.ShowLoading -> {
                    showLoading()
                }

                MainActivityState.HideLoadingDialog -> {
                    hideLoading()
                }
            }
        }
    }

    private fun showLoading() {
        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
    }

    private fun hideLoading() {
    }
}
