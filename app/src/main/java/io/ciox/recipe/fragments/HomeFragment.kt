package io.ciox.recipe.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.ciox.recipe.R
import io.ciox.recipe.adapters.RecipeAdapter
import io.ciox.recipe.databinding.FragmentHomeBinding
import io.ciox.recipe.viewmodel.RecipeViewModel

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

private var _homeBinding:FragmentHomeBinding? = null
    private  val homeBinding get() = _homeBinding!!
    private val recipeViewModel:RecipeViewModel by viewModels()
    private lateinit var recipeAdapter:RecipeAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _homeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeRecyclerView()
    }

    private fun homeRecyclerView(){
        recipeAdapter = RecipeAdapter()
        homeBinding.homeRecycler.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
            adapter = recipeAdapter

        }

        recipeViewModel.recipeResponse.observe(requireActivity(), {

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _homeBinding = null
    }


}