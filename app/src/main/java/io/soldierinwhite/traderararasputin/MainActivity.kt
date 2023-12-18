package io.soldierinwhite.traderararasputin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.soldierinwhite.traderararasputin.common.model.NavigationItem
import io.soldierinwhite.traderararasputin.common.ui.BottomNavigationBar
import io.soldierinwhite.traderararasputin.favorites.FavoritesScreen
import io.soldierinwhite.traderararasputin.home.HomeScreen
import io.soldierinwhite.traderararasputin.ui.theme.AppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                window.decorView.setBackgroundColor(MaterialTheme.colorScheme.background.toArgb())
                window.statusBarColor = MaterialTheme.colorScheme.surfaceVariant.toArgb()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(onSelect = {
                            navController.navigate(
                                when (it) {
                                    NavigationItem.Home -> Destination.Home
                                    NavigationItem.Favorites -> Destination.Favorites
                                    NavigationItem.Settings -> Destination.Settings
                                }.name
                            )
                        })
                    }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Destination.Home.name,
                        modifier = Modifier.padding(it)
                    ) {
                        composable(Destination.Home.name) {
                            HomeScreen()
                        }
                        composable(Destination.Favorites.name) {
                            FavoritesScreen()
                        }
                        composable(Destination.Settings.name) {
                            Spacer(modifier = Modifier)
                        }
                    }
                }
            }
        }
    }
}

enum class Destination {
    Home,
    Favorites,
    Settings
}
