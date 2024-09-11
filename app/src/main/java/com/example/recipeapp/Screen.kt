package com.example.recipeapp

sealed class Screen(route: String) {
   object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")
}