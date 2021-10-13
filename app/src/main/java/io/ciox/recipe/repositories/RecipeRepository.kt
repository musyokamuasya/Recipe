package io.ciox.recipe.repositories

import io.ciox.recipe.api.ApiService
import javax.inject.Inject

class RecipeRepository
@Inject constructor(private val apiService: ApiService)
{
    suspend fun getRecipe() = apiService.getRecipe()
}