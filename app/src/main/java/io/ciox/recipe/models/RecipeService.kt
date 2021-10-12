package io.ciox.recipe.models

data class RecipeService(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)