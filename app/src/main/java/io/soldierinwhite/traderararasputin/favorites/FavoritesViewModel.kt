package io.soldierinwhite.traderararasputin.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.soldierinwhite.traderararasputin.common.db.Product
import io.soldierinwhite.traderararasputin.common.http.HttpClient
import io.soldierinwhite.traderararasputin.common.model.Favorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val realm: Realm,
    httpClient: HttpClient
) : ViewModel() {
    val favoriteProducts: StateFlow<List<Product>> = combine(
        flow { emit(httpClient.getProducts()) },
        realm.query<Favorite>("id != nil SORT(createdEpochMillis DESC)").find().asFlow()
    ) { products, favorites ->
        favorites.list.mapNotNull { favorite -> products.firstOrNull { it.id == favorite.id } }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), listOf())

    fun onRemove(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            realm.write {
                query<Favorite>("id == $0", id).find().firstOrNull()
                    ?.let { delete(it) }
            }
        }
    }
}
