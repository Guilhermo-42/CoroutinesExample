package com.guiherme.coroutines.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.guiherme.coroutines.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.textLive.observe(this, Observer {
            updateUi(it)
        })

        setListeners()
    }

    private fun updateUi(newText: String) {
        mainTextView.text = newText
    }

    private fun setListeners() {
        sendButton.setOnClickListener {
            viewModel.onSubmitClicked()
        }
    }
}
