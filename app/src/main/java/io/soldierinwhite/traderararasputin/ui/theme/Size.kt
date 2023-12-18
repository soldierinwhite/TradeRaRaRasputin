package io.soldierinwhite.traderararasputin.ui.theme

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Size {
    const val imageRatio = 44/63f
}

fun Dp.widthSizeClassFromWidth(): WindowWidthSizeClass {
    require(this >= 0.dp) { "Width must not be negative" }
    return when {
        this < 600.dp -> WindowWidthSizeClass.Compact
        this < 840.dp -> WindowWidthSizeClass.Medium
        else -> WindowWidthSizeClass.Expanded
    }
}
