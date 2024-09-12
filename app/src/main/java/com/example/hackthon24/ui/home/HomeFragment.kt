package com.example.hackthon24.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hackthon24.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sample data
        val parentItems = listOf(
            ParentItem.ParentTypeA(
                "GOA",
                listOf(
                    ChildItem.ChildTypeA("Baga Beach", "Popular beach with vibrant nightlife"),
                    ChildItem.ChildTypeA("Anjuna Beach", "Known for its lively parties and markets"),
                    ChildItem.ChildTypeA("Calangute Beach", "One of the busiest beaches in Goa"),
                    ChildItem.ChildTypeA("Palolem Beach", "A serene and scenic beach"),
                    ChildItem.ChildTypeA("Vagator Beach", "Famous for its scenic beauty and parties")
                )
            ),
            ParentItem.ParentTypeA(
                "GUJARAT",
                listOf(
                    ChildItem.ChildTypeA("Gir Somnath Beach", "Popular for its scenic beauty and Gir National Park"),
                    ChildItem.ChildTypeA("Diu Beach", "Known for its serene environment and historic fort"),
                    ChildItem.ChildTypeA("Mandvi Beach", "A tranquil beach with less crowd"),
                    ChildItem.ChildTypeA("Kutch Beach", "Offers unique salt desert and coastal views")
                )
            ),
            ParentItem.ParentTypeA(
                "KARNATAKA",
                listOf(
                    ChildItem.ChildTypeA("Gokarna Beach", "Known for its religious significance and peaceful atmosphere"),
                    ChildItem.ChildTypeA("Udupi Beach", "Famous for its coastal cuisine and temples"),
                    ChildItem.ChildTypeA("Malpe Beach", "Popular for its water sports and nearby St. Mary's Island"),
                    ChildItem.ChildTypeA("Karwar Beach", "Known for its scenic beauty and peaceful environment")
                )
            ),
            ParentItem.ParentTypeA(
                "KERALA",
                listOf(
                    ChildItem.ChildTypeA("Kovalam Beach", "Famous for its crescent-shaped beaches and lighthouse"),
                    ChildItem.ChildTypeA("Varkala Beach", "Known for its cliffs and backwaters"),
                    ChildItem.ChildTypeA("Alappuzha Beach", "Popular for its backwaters and houseboat rides"),
                    ChildItem.ChildTypeA("Cherai Beach", "A serene beach with a mix of backwaters and sea")
                )
            ),
            ParentItem.ParentTypeA(
                "MAHARASHTRA",
                listOf(
                    ChildItem.ChildTypeA("Juhu Beach", "A famous and crowded beach in Mumbai"),
                    ChildItem.ChildTypeA("Marine Drive Beach", "Known for its scenic promenade and nightlife"),
                    ChildItem.ChildTypeA("Ganpatipule Beach", "Famous for its temple and scenic beauty"),
                    ChildItem.ChildTypeA("Alibaug Beach", "Known for its coastal beauty and relaxed atmosphere")
                )
            ),
            ParentItem.ParentTypeA(
                "TAMIL NADU",
                listOf(
                    ChildItem.ChildTypeA("Marina Beach", "One of the longest urban beaches in the world"),
                    ChildItem.ChildTypeA("Kanyakumari Beach", "Famous for its sunrise and sunset views"),
                    ChildItem.ChildTypeA("Mahabalipuram Beach", "Known for its historic temples and sculptures"),
                    ChildItem.ChildTypeA("Covelong Beach", "Popular for its surfing and water sports")
                )
            ),
            ParentItem.ParentTypeA(
                "ANDHRA PRADESH",
                listOf(
                    ChildItem.ChildTypeA("Visakhapatnam Beach", "Known for its scenic beauty and the nearby Submarine Museum"),
                    ChildItem.ChildTypeA("Ramakrishna Beach", "A popular beach in Visakhapatnam with a lively atmosphere"),
                    ChildItem.ChildTypeA("Rishikonda Beach", "Famous for its clean sands and water sports")
                )
            ),
            ParentItem.ParentTypeA(
                "ODISHA",
                listOf(
                    ChildItem.ChildTypeA("Puri Beach", "Known for its association with the Jagannath Temple and festivals"),
                    ChildItem.ChildTypeA("Gopalpur Beach", "Famous for its quiet and peaceful environment"),
                    ChildItem.ChildTypeA("Chandrabhaga Beach", "Known for its scenic beauty and cultural significance")
                )
            )
        )


        // Setup Parent RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = ParentAdapter(parentItems)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}