package io.soldierinwhite.traderararasputin.ui.theme

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.soldierinwhite.traderararasputin.R

//Fonts
val arvo = FontFamily(
    Font(R.font.arvo_regular, FontWeight.Normal),
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 51.sp
    ),
    displayMedium = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp
    ),
    displaySmall = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    titleLarge = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp
    ),
    titleMedium = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    titleSmall = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    labelLarge = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    labelMedium = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp
    ),
    bodySmall = TextStyle(
        fontFamily = arvo,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )
)

@Preview(showBackground = true)
@Composable
fun TypographyPreview() {
    AppTheme {
        Column(Modifier.scrollable(rememberScrollState(), orientation = Orientation.Vertical)) {
            LoremIpsum(style = MaterialTheme.typography.displayLarge)
            LoremIpsum(style = MaterialTheme.typography.displayMedium)
            LoremIpsum(style = MaterialTheme.typography.displaySmall)
            LoremIpsum(style = MaterialTheme.typography.headlineLarge)
            LoremIpsum(style = MaterialTheme.typography.headlineMedium)
            LoremIpsum(style = MaterialTheme.typography.headlineSmall)
            LoremIpsum(style = MaterialTheme.typography.titleLarge)
            LoremIpsum(style = MaterialTheme.typography.titleMedium)
            LoremIpsum(style = MaterialTheme.typography.titleSmall)
            LoremIpsum(style = MaterialTheme.typography.labelLarge)
            LoremIpsum(style = MaterialTheme.typography.labelMedium)
            LoremIpsum(style = MaterialTheme.typography.labelSmall)
            LoremIpsum(style = MaterialTheme.typography.bodyLarge)
            LoremIpsum(style = MaterialTheme.typography.bodyMedium)
            LoremIpsum(style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun LoremIpsum(style: TextStyle) {
    Text(text = DUMMY_TEXT, style = style)
}

private const val DUMMY_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
