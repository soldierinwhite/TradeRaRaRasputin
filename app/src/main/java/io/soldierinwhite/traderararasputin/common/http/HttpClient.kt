package io.soldierinwhite.traderararasputin.common.http

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import io.soldierinwhite.traderararasputin.common.db.Products

class HttpClient {
    private val ktor = HttpClient(Android) {
        install(ContentNegotiation) {
            gson()
        }
    }

    private val homeUrl = "https://www.tradera.com/static/images/NO_REV/frontend-task/ProductFeedResult.json"

    suspend fun getProducts() = ktor.get(homeUrl).body<Products>().products
}
