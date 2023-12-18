package io.soldierinwhite.traderararasputin.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.soldierinwhite.traderararasputin.common.model.NavigationItem
import io.soldierinwhite.traderararasputin.ui.theme.AppTheme

@Composable
fun BottomNavigationBar(onSelect: (NavigationItem) -> Unit) {
    var selectedItem by remember { mutableIntStateOf(0) }
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.surfaceTint)
    ) {
        NavigationItem.entries.forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    onSelect(navigationItem)
                },
                label = { Text(stringResource(navigationItem.labelId), style = MaterialTheme.typography.labelSmall) },
                icon = {
                    Icon(
                        painter = painterResource(id = navigationItem.iconId),
                        contentDescription = null,
                    )
                })
        }
    }
}

@Preview
@Composable
fun BottomNavigationBar_Preview() {
    AppTheme {
        BottomNavigationBar(onSelect = {})
    }
}
