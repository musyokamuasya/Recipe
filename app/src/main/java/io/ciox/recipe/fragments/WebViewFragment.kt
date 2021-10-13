package io.ciox.recipe.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import io.ciox.recipe.R
import io.ciox.recipe.databinding.FragmentWebViewBinding

@AndroidEntryPoint
class WebViewFragment : Fragment(R.layout.fragment_web_view) {
    private var _webViewBinding:FragmentWebViewBinding? = null
    private val webViewBinding get() = _webViewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _webViewBinding = FragmentWebViewBinding.inflate(inflater, container, false)

        return webViewBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _webViewBinding = null
    }

}