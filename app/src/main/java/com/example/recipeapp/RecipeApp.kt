package com.example.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel: MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState
    NavHost(navController = navController, startDestination = "recipescreen") {
       composable(route= "recipescreen"){
           RecipeScreen(viewstate = viewstate, navigateToDetail = {
              // This part is responsible for passing data from the current screen to the detail screen.
               // It utilizes the savedStateHandle, which is a component of the Compose Navigation framework.
               navController.currentBackStackEntry?.savedStateHandle?.set("cat",it) // nullable string?: , cat-> key value pair
               navController.navigate("detailscreen")
           })

       }
        composable(route = "detailscreen"){
         val category = navController.previousBackStackEntry?.savedStateHandle?.
         get<Category>("cat")?: Category(" "," ","", "")
        }
    }
}