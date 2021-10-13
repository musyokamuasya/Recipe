package io.ciox.recipe.api

import io.ciox.recipe.models.RecipeResponse
import io.ciox.recipe.util.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getRecipe():Response<RecipeResponse>


}