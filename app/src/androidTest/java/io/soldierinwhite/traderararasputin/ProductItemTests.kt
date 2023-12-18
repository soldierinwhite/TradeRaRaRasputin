package io.soldierinwhite.traderararasputin

import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import io.soldierinwhite.traderararasputin.common.db.Product
import io.soldierinwhite.traderararasputin.home.ProductItem
import io.soldierinwhite.traderararasputin.ui.theme.AppTheme
import org.junit.Test

class ProductItemTests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun onFavoriteClick_triggersLambda() {
        val product = Product(id = "", title = "", price = 0, currency = "", image = "")
        val isFavorite = false
        var count = 0

        composeTestRule.setContent {
            AppTheme {
                ProductItem(product = product, isFavorite = isFavorite, onFavoriteClick = { count++ })
            }
        }

        composeTestRule.onNodeWithContentDescription("Lägg till som favorit").performClick()

        assert(count == 1)
    }

    @Test
    fun productItem_showsTitleAndPriceInCorrectFormat() {
        val product = Product(id = "", title = "Title", price = 30, currency = "SEK", image = "")
        val isFavorite = false

        composeTestRule.setContent {
            AppTheme {
                ProductItem(product = product, isFavorite = isFavorite, onFavoriteClick = {})
            }
        }

        composeTestRule.onNodeWithContentDescription("Lägg till som favorit").performClick()

        composeTestRule.onNodeWithText("30 SEK").assertIsDisplayed()
        composeTestRule.onNodeWithText("Title").assertIsDisplayed()
    }
}
