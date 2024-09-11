package com.example.recipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.create
import retrofit2.http.GET   // imported to get htttp requests

// after dot- it's like calling functions over functions
// retrofit - an object
private val retrofit= Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService= retrofit.create(ApiService::class.java)

interface ApiService{
    @GET("categories.php")
    suspend fun getCategories():CategoriesResponse  // this getCategories gets Categories from internet using retrofit then recipeService enables us to use
}