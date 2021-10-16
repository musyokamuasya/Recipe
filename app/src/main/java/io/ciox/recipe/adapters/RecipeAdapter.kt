package io.ciox.recipe.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import io.ciox.recipe.databinding.DesignRecipeBinding
import io.ciox.recipe.models.Result


class RecipeAdapter:RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder (val binding: DesignRecipeBinding):RecyclerView.ViewHolder(
        binding.root
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            DesignRecipeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentRecipe = recipe[position]

        holder.binding.apply {
                recipeTitle.text = currentRecipe.title
                recipeThumbnail.load(currentRecipe.image){
                    crossfade(true)
                    crossfade(1000)

                }
        }
    }

    override fun getItemCount() = recipe.size

    private val diffCallBack = object :DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
          return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var recipe: List<Result>
        get() = differ.currentList
        set(value){
            differ.submitList(value)
        }

}

