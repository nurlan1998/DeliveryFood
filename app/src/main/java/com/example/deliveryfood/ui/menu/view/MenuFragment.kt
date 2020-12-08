package com.example.deliveryfood.ui.menu.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.deliveryfood.App
import com.example.deliveryfood.R
import com.example.deliveryfood.adapters.HorizontalMenuAdapter
import com.example.deliveryfood.adapters.NewsPaperAdapter
import com.example.deliveryfood.adapters.OnItemClick
import com.example.deliveryfood.data.Repository
import com.example.deliveryfood.data.local.AppRoomDatabase
import com.example.deliveryfood.data.local.dao.MenuDao
import com.example.deliveryfood.other.Constants
import com.example.deliveryfood.ui.menu.viewmodel.MenuViewModel
import com.example.deliveryfood.ui.menu.viewmodel.MenuViewModelFactory
import com.example.deliveryfood.ui.menu.model.*
import com.example.deliveryfood.ui.nearme.view.NearMeFragmentDirections
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.item_horizontal.view.*


class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var adapter: NewsPaperAdapter
    private lateinit var menuViewModel: MenuViewModel
    private lateinit var menuViewModelFactory: MenuViewModelFactory
    private lateinit var db: AppRoomDatabase
    private lateinit var cartDao: MenuDao
    private val args: MenuFragmentArgs by navArgs()
    private lateinit var horizontalMenuAdapter: HorizontalMenuAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setupRecyclerView()
        setDataAdapter()
        setupDataRestaurant()

        adapter.setOnItemClick(object : OnItemClick {

            override fun deleteCart(headlinesMenu: HeadlinesMenu) {
                menuViewModel.deleteMenu(headlinesMenu)
            }

            override fun addCard(headlinesMenu: HeadlinesMenu) {
                menuViewModel.insertMenu(headlinesMenu)
            }
        })

        menuViewModel.getCartCount().observe(viewLifecycleOwner, Observer {
            if (it == 0) {
                cart_badge_counter?.visibility = View.GONE
            } else {
                cart_badge_counter?.visibility = View.VISIBLE
                cart_badge_counter?.text = it.toString()
            }
        })

        btm_nav_cart.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_cartFragment)
        }

        var item = NewsPaperMenu()
        item.isExpanded = true
        adapter.onItemClickedExpandable(item)
    }

    private fun setupDataRestaurant() {
        tvMainNameMenu.text = args.titleRestaurant
        Glide.with(requireActivity()).load(Constants.BASE_URL + args.imageRestaurant)
            .into(ivMainMenu)
    }

    private fun setupRecyclerView() {
        adapter =
            NewsPaperAdapter(requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        horizontalMenuAdapter = HorizontalMenuAdapter()
        rvHorizontalMenu.adapter = horizontalMenuAdapter
    }

    private fun init() {
        val repository = Repository()
        menuViewModelFactory = MenuViewModelFactory(repository = repository)

        menuViewModel = ViewModelProvider(requireActivity(), menuViewModelFactory).get(MenuViewModel::class.java)

        menuViewModel.startViewModel()
        menuViewModel.getMenu(args.id)
    }

    override fun onResume() {
        super.onResume()
        db = App.getDatabase()
        cartDao = db.getMenuDao()
    }

    private fun setDataAdapter() {
        menuViewModel.menuLiveData.observe(viewLifecycleOwner, Observer {
            val response = it.body()?.newsPaperMenu
            val responseHorizontal = it.body()?.recommended
            Log.i("Recommended",responseHorizontal.toString())
            adapter.data = response as MutableList<NewsPaperMenu>
            horizontalMenuAdapter.models = responseHorizontal!!
            horizontalMenuAdapter.setItemClick {recommended ->
                var id = recommended.id
                val action = MenuFragmentDirections.actionMenuFragmentToDetailFragment(id)
                findNavController().navigate(action)
            }
        })
    }
}