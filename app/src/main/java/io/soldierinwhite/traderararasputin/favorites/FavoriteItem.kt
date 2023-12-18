package io.soldierinwhite.traderararasputin.favorites

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.soldierinwhite.traderararasputin.common.db.Product
import io.soldierinwhite.traderararasputin.ui.theme.AppTheme
import io.soldierinwhite.traderararasputin.ui.theme.Size

@Composable
fun FavoriteItem(product: Product) {
    Row(
        modifier = Modifier
            .background(
                color = getFavoritePriceCategoryColor(price = product.price),
                shape = RoundedCornerShape(4.dp)
            )
            .fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .height(128.dp)
                .aspectRatio(Size.imageRatio)
                .padding(8.dp),
            model = product.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = ColorPainter(MaterialTheme.colorScheme.surfaceVariant)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp), verticalArrangement = Arrangement.Center
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
}

@Preview(showBackground = true)
@Preview(showBackground = true, apiLevel = 30)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true, fontScale = 2.0f)
@Composable
fun FavoriteItem_Preview() {
    AppTheme {
        FavoriteItem(
            product = Product(
                id = "tibique",
                title = "vocibus",
                price = 600,
                currency = "SEK",
                image = "loremipsum"
            )
        )
    }
}

@Composable
fun getFavoritePriceCategoryColor(price: Int): Color = when (price) {
    in (0..50) -> MaterialTheme.colorScheme.secondaryContainer
    in (50..500) -> MaterialTheme.colorScheme.tertiaryContainer
    else -> MaterialTheme.colorScheme.primaryContainer
}
