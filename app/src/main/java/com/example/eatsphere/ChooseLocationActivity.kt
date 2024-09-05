package com.example.eatsphere

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eatsphere.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {
    private val binding: ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Define the list of locations
        val locationList= arrayOf("Jaipur", "Bundi", "Sikar", "Badmer", "Bikaner", "Ajmer", "Kota")

        // Create an ArrayAdapter with the list of locations
        val adapter= ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)

        // Set the adapter to the AutoCompleteTextView
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)
    }
}
