package com.example.eatsphere.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eatsphere.R
import com.example.eatsphere.adaptar.BuyAgainAdapter
import com.example.eatsphere.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)

        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val buyAgainFoodName = arrayListOf("Food 2", "Food 2", "Food 3")
        val buyAgainFoodPrice = arrayListOf("$10", "$0", "$30")
        val buyAgainFoodImage = arrayListOf(R.drawable.aaloparatha, R.drawable.vegburger, R.drawable.lasgna)
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage)
        binding.buyAgainRecyclerView.adapter = buyAgainAdapter
        binding.buyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    companion object {
        // You can add any companion object methods or variables here if needed.
    }
}
