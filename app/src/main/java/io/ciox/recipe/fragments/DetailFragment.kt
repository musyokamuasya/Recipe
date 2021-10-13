package io.ciox.recipe.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import io.ciox.recipe.R
import io.ciox.recipe.databinding.FragmentDetailBinding

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var _detailBinding:FragmentDetailBinding? = null
    private val detailBinding get() = _detailBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _detailBinding = null
    }

}