package com.gabrielgrs.moviedb.core.plataform

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.gabrielgrs.moviedb.R
import com.irozon.sneaker.Sneaker
import java.net.UnknownHostException

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    private lateinit var binding: T

    protected abstract fun getContentLayoutId(): Int
    protected abstract fun init()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getContentLayoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    protected fun handleError(error: Throwable) {
        error.message?.let {
            Log.e("ERROR_SERVICE", it)
        }

        val message: String = when (error) {
            is UnknownHostException -> getString(R.string.generic_server_down)
            else -> getString(R.string.generic_server_down)
        }

        Sneaker.with(this)
            .setTitle(getString(R.string.generic_error_toast))
            .setMessage(message)
            .sneakError()
    }
}