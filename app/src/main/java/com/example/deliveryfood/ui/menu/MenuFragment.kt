package com.example.deliveryfood.ui.menu

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryfood.App
import com.example.deliveryfood.R
import com.example.deliveryfood.adapters.HeadlinesAdapter
import com.example.deliveryfood.adapters.NewsPaperAdapter
import com.example.deliveryfood.data.Repository
import com.example.deliveryfood.data.local.AppRoomDatabase
import com.example.deliveryfood.data.local.dao.CartDao
import com.example.deliveryfood.data.network.RetrofitInstance
import com.example.deliveryfood.ui.menu.model.*
import com.google.android.material.badge.BadgeDrawable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_menu.*
import retrofit2.Response


class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var adapter: NewsPaperAdapter
    private lateinit var menuViewModel: MenuViewModel
    private lateinit var menuViewModelFactory: MenuViewModelFactory
    private lateinit var db: AppRoomDatabase
    private lateinit var cartDao: CartDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        getRequestPath()
        setupRecyclerView()

        adapter.setOnItemClickCallBack(object : NewsPaperAdapter.OnItemClick {
            override fun onItemClicked(count: Int?) {
                Toast.makeText(requireContext(), count.toString(), Toast.LENGTH_SHORT).show()
//                Log.i("Count",clicked.toString())
                cart_badge_counter.text = count.toString()
            }

            override fun addCard(headlinesModel: HeadlinesModel) {
//                Toast.makeText(requireContext(),headlinesModel.name,Toast.LENGTH_SHORT).show()

            }
        })

        btm_nav_cart.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_cartFragment)
        }

        var item = NewsPaperModel()
        item.isExpanded = true
        adapter.onItemClicked(item)
    }

    private fun setupRecyclerView() {
        adapter =
            NewsPaperAdapter(requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun init() {
        val repository = Repository()
        menuViewModelFactory = MenuViewModelFactory(repository = repository)
        menuViewModel = ViewModelProvider(
            requireActivity(),
            menuViewModelFactory
        ).get(MenuViewModel::class.java)
        menuViewModel.startViewModel()
        menuViewModel.getMenu("restaurant-neo-nxknkg0gabigc00")
        db = App.getDatabase()
        cartDao = db.getCartDao()

    }

    private fun getRequestPath() {
        menuViewModel.menuLiveData.observe(viewLifecycleOwner, Observer {
            val response = it.body()?.newsPaper
            adapter.data = response as MutableList<NewsPaperModel>
        })
    }
}