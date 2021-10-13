package io.ciox.recipe.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ciox.recipe.models.RecipeResponse
import io.ciox.recipe.repositories.RecipeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel
@Inject constructor(private val repository: RecipeRepository) : ViewModel(){
    private val _response = MutableLiveData<RecipeResponse>()
    val recipeResponse:LiveData<RecipeResponse>
    get() = _response

    init {
       getRecipe()
    }

    private fun getRecipe() = viewModelScope.launch {
        repository.getRecipe().let { response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
                Log.d("Response", "Response successful")
            }
            else{
            Log.d("Response Error", "Get recipe ${response.code()}")
            }
        }
    }
}

