package com.example.eatsphere.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.eatsphere.MenuBottomSheetFragment

import com.example.eatsphere.R
import com.example.eatsphere.adaptar.PopularAdaptar
import com.example.eatsphere.databinding.FragmentHomeBinding
import org.jetbrains.annotations.TestOnly


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize binding first
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Set up the button click listener after binding is initialized
        binding.viewAllMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager, "Test")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.biryani, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.burgeroff, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.deserts, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.lassii, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.pannerbutter, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.pizzza, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider

        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                // TODO: Handle double-click event
            }

            override fun onItemSelected(position: Int) {
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })

        val foodName = listOf("Aaloo Paratha", "Appam", "Apple Pie", "BBQ Ribs", "Beef Wellington", "Bruschetta", "Butter Chicken", "Caesar Salad", "Chicken Burger", "Chicken Wings", "Chole Bhature", "Creme Brulee", "Dal Makhni", "Dosa", "French Fries", "Fried Chicken", "Grilled Chicken", "Gulab Jamun", "Hot Dog", "Kadhai Chicken", "Lasagna", "Lassi", "Mac and Cheese", "Mashed Potatoes", "Medu Vada", "Moussaka", "Mysore Pak", "Naan", "Neer Dosa", "Palak Paneer", "Pancakes", "Paneer Butter Masala", "Pasta", "Pesarattu", "Pongal", "Quiche", "Rasam", "Risotto", "Rogan Josh", "Sambhar Rice", "Steak", "Stuffed Pepper", "Tandoori Chicken", "Tiramisu", "Uttapam", "Vada", "Veg Burger")
        val price = listOf("5$", "3$", "7$", "10$", "15$", "4$", "8$", "6$", "5$", "6$", "4$", "7$", "6$", "3$", "2$", "9$", "10$", "4$", "5$", "8$", "7$", "2$", "5$", "3$", "2$", "9$", "4$", "1$", "3$", "7$", "5$", "8$", "6$", "3$", "4$", "7$", "2$", "9$", "10$", "6$", "15$", "7$", "10$", "6$", "4$", "2$", "5$")
        val popularFoodImages = listOf(
            R.drawable.aaloparatha, R.drawable.appam, R.drawable.applepie, R.drawable.bbqribs,
            R.drawable.beefwelington, R.drawable.buscheta, R.drawable.butterchicken,
            R.drawable.caesarsalad, R.drawable.chickenburger, R.drawable.chickenwings,
            R.drawable.cholebhature, R.drawable.cremebrule, R.drawable.dalmakhni, R.drawable.dosa,
            R.drawable.frenchfries, R.drawable.friedchicken, R.drawable.grilledchicken,
            R.drawable.gulabjamun, R.drawable.hotdog, R.drawable.kadhaichicken, R.drawable.lasgna,
            R.drawable.lassi, R.drawable.macandcheese, R.drawable.mashedpotatoes,
            R.drawable.meduvada, R.drawable.moussaka, R.drawable.mysorepak, R.drawable.naan,
            R.drawable.neerdosa, R.drawable.palakpanner, R.drawable.pancakes,
            R.drawable.paneerbuttermasala, R.drawable.pasta, R.drawable.pesarattu,
            R.drawable.pongal, R.drawable.quiche, R.drawable.rasam, R.drawable.risotto,
            R.drawable.roganjosh, R.drawable.sambharrice, R.drawable.steak, R.drawable.stuffedpepper,
            R.drawable.tandorichicken, R.drawable.tiramisu, R.drawable.uttapam, R.drawable.vada,
            R.drawable.vegburger
        )

        val adapter = PopularAdaptar(foodName, price, popularFoodImages,requireContext())
        binding.PopularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.PopularRecyclerView.adapter = adapter
    }
}
