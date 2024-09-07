package com.example.eatsphere.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView  // Correct import
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eatsphere.R
import com.example.eatsphere.adaptar.MenuAdapter
import com.example.eatsphere.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuFoodName = listOf("Aaloo Paratha", "Appam", "Apple Pie", "BBQ Ribs", "Beef Wellington", "Bruschetta", "Butter Chicken", "Caesar Salad", "Chicken Burger", "Chicken Wings", "Chole Bhature", "Creme Brulee", "Dal Makhni", "Dosa", "French Fries", "Fried Chicken", "Grilled Chicken", "Gulab Jamun", "Hot Dog", "Kadhai Chicken", "Lasagna", "Lassi", "Mac and Cheese", "Mashed Potatoes", "Medu Vada", "Moussaka", "Mysore Pak", "Naan", "Neer Dosa", "Palak Paneer", "Pancakes", "Paneer Butter Masala", "Pasta", "Pesarattu", "Pongal", "Quiche", "Rasam", "Risotto", "Rogan Josh", "Sambhar Rice", "Steak", "Stuffed Pepper", "Tandoori Chicken", "Tiramisu", "Uttapam", "Vada", "Veg Burger")
    private val originalMenuItemPrice = listOf("5$", "3$", "7$", "10$", "15$", "4$", "8$", "6$", "5$", "6$", "4$", "7$", "6$", "3$", "2$", "9$", "10$", "4$", "5$", "8$", "7$", "2$", "5$", "3$", "2$", "9$", "4$", "1$", "3$", "7$", "5$", "8$", "6$", "3$", "4$", "7$", "2$", "9$", "10$", "6$", "15$", "7$", "10$", "6$", "4$", "2$", "5$")
    private val originalMenuImage = listOf(R.drawable.aaloparatha, R.drawable.appam, R.drawable.applepie, R.drawable.bbqribs, R.drawable.beefwelington, R.drawable.buscheta, R.drawable.butterchicken, R.drawable.caesarsalad, R.drawable.chickenburger, R.drawable.chickenwings, R.drawable.cholebhature, R.drawable.cremebrule, R.drawable.dalmakhni, R.drawable.dosa, R.drawable.frenchfries, R.drawable.friedchicken, R.drawable.grilledchicken, R.drawable.gulabjamun, R.drawable.hotdog, R.drawable.kadhaichicken, R.drawable.lasgna, R.drawable.lassi, R.drawable.macandcheese, R.drawable.mashedpotatoes, R.drawable.meduvada, R.drawable.moussaka, R.drawable.mysorepak, R.drawable.naan, R.drawable.neerdosa, R.drawable.palakpanner, R.drawable.pancakes, R.drawable.paneerbuttermasala, R.drawable.pasta, R.drawable.pesarattu, R.drawable.pongal, R.drawable.quiche, R.drawable.rasam, R.drawable.risotto, R.drawable.roganjosh, R.drawable.sambharrice, R.drawable.steak, R.drawable.stuffedpepper, R.drawable.tandorichicken, R.drawable.tiramisu, R.drawable.uttapam, R.drawable.vada, R.drawable.vegburger)

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter=  MenuAdapter(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        setupSearchView()
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)
        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)) {
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {
    }
}
