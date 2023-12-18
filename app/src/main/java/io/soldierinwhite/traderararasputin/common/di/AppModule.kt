package io.soldierinwhite.traderararasputin.common.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.soldierinwhite.traderararasputin.common.db.openRealm
import io.soldierinwhite.traderararasputin.common.http.HttpClient
import io.soldierinwhite.traderararasputin.common.time.Clock
import java.time.Instant
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun applicationContext(application: Application): Context = application.applicationContext

    @Provides
    fun httpClient(): HttpClient = HttpClient()

    @Provides
    fun realm(): Realm = openRealm()

    @Provides
    fun clock(): Clock = object: Clock {
        override fun currentEpochMillis() = System.currentTimeMillis()
    }

    @Provides
    fun sharedPreferences(application: Application): SharedPreferences = application.getSharedPreferences("TradeRaRaRasputin", Context.MODE_PRIVATE)
}
