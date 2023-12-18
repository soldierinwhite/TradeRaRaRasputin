package io.soldierinwhite.traderararasputin.common.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Favorite(
    @PrimaryKey var id: String,
    var createdEpochMillis: Long
) : RealmObject {
    constructor() : this("", 0L)
}
