package com.gabrielgrs.moviedb.core.helper

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface ResourceHelper {
    fun getString(@StringRes resId: Int): String

    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String

    fun getDrawable(@DrawableRes resId: Int): Drawable?

    @ColorInt
    fun getColor(@ColorRes resId: Int): Int

    fun getContext(): Context
}