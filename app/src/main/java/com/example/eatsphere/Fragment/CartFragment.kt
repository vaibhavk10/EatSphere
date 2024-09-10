package com.example.eatsphere.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eatsphere.CongratsBottomSheet
import com.example.eatsphere.PayOutActivity
import com.example.eatsphere.R
import com.example.eatsphere.adaptar.CartAdapter
import com.example.eatsphere.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container,false)

        val cartFoodName = listOf("Aaloo Paratha", "Appam", "Apple Pie", "BBQ Ribs", "Beef Wellington", "Bruschetta", "Butter Chicken", "Caesar Salad", "Chicken Burger", "Chicken Wings", "Chole Bhature", "Creme Brulee", "Dal Makhni", "Dosa", "French Fries", "Fried Chicken", "Grilled Chicken", "Gulab Jamun", "Hot Dog", "Kadhai Chicken", "Lasagna", "Lassi", "Mac and Cheese", "Mashed Potatoes", "Medu Vada", "Moussaka", "Mysore Pak", "Naan", "Neer Dosa", "Palak Paneer", "Pancakes", "Paneer Butter Masala", "Pasta", "Pesarattu", "Pongal", "Quiche", "Rasam", "Risotto", "Rogan Josh", "Sambhar Rice", "Steak", "Stuffed Pepper", "Tandoori Chicken", "Tiramisu", "Uttapam", "Vada", "Veg Burger")
        val cartItemPrice = listOf("5$", "3$", "7$", "10$", "15$", "4$", "8$", "6$", "5$", "6$", "4$", "7$", "6$", "3$", "2$", "9$", "10$", "4$", "5$", "8$", "7$", "2$", "5$", "3$", "2$", "9$", "4$", "1$", "3$", "7$", "5$", "8$", "6$", "3$", "4$", "7$", "2$", "9$", "10$", "6$", "15$", "7$", "10$", "6$", "4$", "2$", "5$")
        val cartImage = listOf(R.drawable.aaloparatha, R.drawable.appam, R.drawable.applepie, R.drawable.bbqribs, R.drawable.beefwelington, R.drawable.buscheta, R.drawable.butterchicken, R.drawable.caesarsalad, R.drawable.chickenburger, R.drawable.chickenwings, R.drawable.cholebhature, R.drawable.cremebrule, R.drawable.dalmakhni, R.drawable.dosa, R.drawable.frenchfries, R.drawable.friedchicken, R.drawable.grilledchicken, R.drawable.gulabjamun, R.drawable.hotdog, R.drawable.kadhaichicken, R.drawable.lasgna, R.drawable.lassi, R.drawable.macandcheese, R.drawable.mashedpotatoes, R.drawable.meduvada, R.drawable.moussaka, R.drawable.mysorepak, R.drawable.naan, R.drawable.neerdosa, R.drawable.palakpanner, R.drawable.pancakes, R.drawable.paneerbuttermasala, R.drawable.pasta, R.drawable.pesarattu, R.drawable.pongal, R.drawable.quiche, R.drawable.rasam, R.drawable.risotto, R.drawable.roganjosh, R.drawable.sambharrice, R.drawable.steak, R.drawable.stuffedpepper, R.drawable.tandorichicken, R.drawable.tiramisu, R.drawable.uttapam, R.drawable.vada, R.drawable.vegburger)


        val adapter = CartAdapter(ArrayList(cartFoodName), ArrayList(cartItemPrice), ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter


        binding.proceedButton.setOnClickListener {
            val intent = Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }


        return binding.root

    }

    companion object {
    }
}
