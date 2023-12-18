package io.soldierinwhite.traderararasputin.home

import FavoriteButton
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.soldierinwhite.traderararasputin.common.db.Product
import io.soldierinwhite.traderararasputin.ui.theme.AppTheme
import io.soldierinwhite.traderararasputin.ui.theme.Size

@Composable
fun ProductItem(
    product: Product,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val fontScale = LocalConfiguration.current.fontScale
    Column(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(8.dp)
    ) {
        Box {
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .fillMaxWidth()
                    .aspectRatio(Size.imageRatio),
                model = product.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(MaterialTheme.colorScheme.surfaceVariant)
            )
            FavoriteButton(onClick = onFavoriteClick, isFavorite = isFavorite, modifier = Modifier.align(Alignment.TopEnd).padding(8.dp))
        }
        if (fontScale < 1.5) {
            ProductDescriptionRow(product = product)
        } else {
            ProductDescriptionColumn(product = product)
        }
    }
}

@Composable
fun ProductDescriptionRow(product: Product) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = product.title,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(end = 4.dp)
                .weight(1f)
        )
        Text(
            "${product.price} ${product.currency}",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun ProductDescriptionColumn(product: Product) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = product.title,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            "${product.price} ${product.currency}",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, apiLevel = 30)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true, fontScale = 2.0f)
@Composable
fun ProductItem_Preview() {
    AppTheme {
        ProductItem(
            product = Product(
                "",
                title = "Back to the Future",
                price = 50,
                currency = "SEK",
                image = ""
            ),
            onFavoriteClick = {},
            isFavorite = false,
            modifier = Modifier.width(240.dp)
        )
    }
}
