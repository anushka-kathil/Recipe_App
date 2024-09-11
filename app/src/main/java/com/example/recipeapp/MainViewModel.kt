package com.example.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val _categorieState = mutableStateOf(RecipeState()) // this mutableStateOf is enabling us to change UI
    val categoriesState: State<RecipeState> = _categorieState  // It updates user Interface whenever there is any change in RecipeState,
    // this categoriesState expose the categories to other classes and composables, Composables which we are going to call in our mainactivity that takes care of UI.

    init {
        fetchCategories()
    }


    private fun fetchCategories(){
        // coroutine allows you to run a routine in background, suspend keyword
        viewModelScope.launch {
           // try and catch allows us to trap error and display the error
          // this function run this coroutine which will call "get categories" which uses suspend
            try {
                val response = recipeService.getCategories()  // everything we have fetched from internet will be stored in this variable "response"
                _categorieState.value = _categorieState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            }catch (e:Exception){
                _categorieState.value = _categorieState.value.copy(
                    loading=false,
                    error="Error fetching Categories ${e.message}"
                )
            }
        }
    }



    data class RecipeState(
        val loading:Boolean=true,
        val list: List<Category> = emptyList(),
        val error: String?=null         // to declare nullable string we need to add question mark
    )
}