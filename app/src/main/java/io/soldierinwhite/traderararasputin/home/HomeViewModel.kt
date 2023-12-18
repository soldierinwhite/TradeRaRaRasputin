package io.soldierinwhite.traderararasputin.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.soldierinwhite.traderararasputin.common.db.Product
import io.soldierinwhite.traderararasputin.common.http.HttpClient
import io.soldierinwhite.traderararasputin.common.model.Favorite
import io.soldierinwhite.traderararasputin.common.time.Clock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    httpClient: HttpClient,
    private val realm: Realm,
    private val clock: Clock
) : ViewModel() {
    val products: StateFlow<List<ProductInHome>> = combine(
        flow { emit(httpClient.getProducts()) },
        realm.query<Favorite>().find().asFlow()
    ) { products, favorites ->
        products.map { product ->
            ProductInHome(
                product = product,
                isFavorite = favorites.list.any { it.id == product.id }
            )
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), listOf())

    fun onFavoriteClick(id: String, toggled: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            realm.write {
                if (toggled) {
                    copyToRealm(Favorite(id, clock.currentEpochMillis()))
                } else {
                    val favoriteToDelete = query<Favorite>("id == $0", id).find().firstOrNull()
                    favoriteToDelete?.let { delete(it) }
                }
            }
        }
    }
}


data class ProductInHome(
    val product: Product,
    val isFavorite: Boolean
)
