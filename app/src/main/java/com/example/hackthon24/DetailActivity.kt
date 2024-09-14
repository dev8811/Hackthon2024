package com.example.hackthon24


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hackthon24.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from the intent
        val name = intent.getStringExtra(EXTRA_NAME) ?: "No Name"
        val description = intent.getStringExtra(EXTRA_DESCRIPTION) ?: "No Description"

        // Display the data

        binding.tvDetailName.text = name
        binding.tvDetailDescription.text = description
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
    }
}
