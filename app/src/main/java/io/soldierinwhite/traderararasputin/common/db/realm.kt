package io.soldierinwhite.traderararasputin.common.db

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.soldierinwhite.traderararasputin.common.model.Favorite

val schema = setOf(Favorite::class)

fun openRealm() = Realm.open(RealmConfiguration.create(schema))
