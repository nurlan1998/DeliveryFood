package com.example.deliveryfood.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryfood.data.Repository
import com.example.deliveryfood.ui.menu.model.HeadlinesMenu
import com.example.deliveryfood.ui.menu.model.MenuResponse
import com.example.deliveryfood.ui.menu.model.NewsPaperMenu
import kotlinx.coroutines.launch
import retrofit2.Response

class MenuViewModel(var repository: Repository) : ViewModel() {

    //    var menuLiveData: MutableLiveData<List<NewsPaperModel>> = MutableLiveData()
    var menuLiveData: MutableLiveData<Response<MenuResponse>> = MutableLiveData()
    var cardLiveData: MutableLiveData<HeadlinesMenu> = MutableLiveData()

    fun getMenu(slug: String) {
        viewModelScope.launch {
            val response = repository.getMenuRestaurant(slug = slug)
            menuLiveData.value = response
        }
    }

    fun insertMenu(headlinesMenu: HeadlinesMenu) = viewModelScope.launch { repository.insertMenu(headlinesMenu) }
    fun deleteMenu(headlinesMenu: HeadlinesMenu) = viewModelScope.launch { repository.deleteMenu(headlinesMenu) }

    fun getCartCount(): LiveData<Int>{
        return repository.getCountCart()
    }


    fun startViewModel() {
        val members = mutableListOf<NewsPaperMenu>()
        val members2 = mutableListOf<HeadlinesMenu>()

        for (i in 0..5) {
//            val member =
//                HeadlinesModel(
//                    addonCategories = ,
//                    categoryName = "",
//                    desc = "",
//                    id = 0,
//                    image = "https://media-cdn.tripadvisor.com/media/photo-f/18/e1/30/aa/cinnamon-coffee-pastry.jpg",
//                    isActive = 0,
//                    isNew = 0,
//                    isPopular = 0,
//                    isRecommended = 0,
//                    isVeg = 0,
//                    itemCategoryId = 0,
//                    name = "Пицца",
//                    oldPrice = "400",
//                    placeholderImage = "",
//                    price = "5000",
//                    restaurantId = 0
//                )
//            members2.add(member)
        }

        for (i in 0..5) {
            val member =
                NewsPaperMenu(
                    headlines = members2,
                    id = 0,
                    name = "Плов",
                    isExpanded = false
                )
            members.add(member)
        }
//        menuLiveData.value = members
    }
}