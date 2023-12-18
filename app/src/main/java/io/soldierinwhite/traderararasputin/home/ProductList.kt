package io.soldierinwhite.traderararasputin.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.soldierinwhite.traderararasputin.R
import io.soldierinwhite.traderararasputin.common.db.Product
import io.soldierinwhite.traderararasputin.ui.theme.AppTheme

@Composable
fun ProductList(
    products: List<ProductInHome>,
    windowWidthSizeClass: WindowWidthSizeClass,
    onFavoriteClick: (String, Boolean) -> Unit
) {
    val columns = when (windowWidthSizeClass) {
        WindowWidthSizeClass.Compact -> 2
        WindowWidthSizeClass.Medium -> 3
        else -> 4
    }
    val fullSpan = GridItemSpan(columns)
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        contentPadding = PaddingValues(8.dp)
    ) {
        item(span = { fullSpan }) {
            Text(
                stringResource(R.string.explore),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
        item(span = { fullSpan }) {
            Divider(
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 4.dp, bottom = 16.dp, start = 8.dp, end = 8.dp)
            )
        }
        items(products) {
            ProductItem(
                product = it.product,
                isFavorite = it.isFavorite,
                onFavoriteClick = { onFavoriteClick(it.product.id, !it.isFavorite) })
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, apiLevel = 30)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true, fontScale = 2.0f)
@Composable
fun ProductList_Preview() {
    AppTheme {
        ProductList(
            products = previewList,
            onFavoriteClick = { _, _ -> },
            windowWidthSizeClass = WindowWidthSizeClass.Compact
        )
    }
}

val previewList = listOf(
    ProductInHome(
        product = Product(
            id = "omittantur",
            title = "Conubia",
            price = 815,
            currency = "SEK",
            image = "autem"
        ), isFavorite = false
    ),
    ProductInHome(
        product = Product(
            id = "veritus",
            title = "No",
            price = 309,
            currency = "SEK",
            image = "quod"
        ), isFavorite = true
    ),
    ProductInHome(
        product = Product(
            id = "nostrum",
            title = "Porta",
            price = 754,
            currency = "SEK",
            image = "lacinia"
        ), isFavorite = true
    ),
    ProductInHome(
        Product(
            id = "convenire",
            title = "Ante",
            price = 562,
            currency = "SEK",
            image = "suspendisse"
        ), isFavorite = false
    )
)
