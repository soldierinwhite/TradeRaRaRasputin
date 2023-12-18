package io.soldierinwhite.traderararasputin.common.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.soldierinwhite.traderararasputin.R

enum class NavigationItem(@StringRes val labelId: Int, @DrawableRes val iconId: Int) {
    Home(R.string.explore, R.drawable.explore),
    Favorites(R.string.favorites, R.drawable.favorite),
    Settings(R.string.settings, R.drawable.settings)
}
