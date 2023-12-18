package io.soldierinwhite.traderararasputin.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.soldierinwhite.traderararasputin.ui.theme.widthSizeClassFromWidth

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val windowWidthSizeClass = LocalConfiguration.current.screenWidthDp.dp.widthSizeClassFromWidth()
    ProductList(
        products = viewModel.products.collectAsStateWithLifecycle().value,
        onFavoriteClick = { id, toggled -> viewModel.onFavoriteClick(id, toggled) },
        windowWidthSizeClass = windowWidthSizeClass
    )
}
