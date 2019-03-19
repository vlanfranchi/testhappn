package com.jehutyno.testhappn.framework.favorites

import com.jehutyno.domain.model.Favorite
import com.jehutyno.testhappn.Converter
import com.jehutyno.testhappn.database.favorites.FavoriteRoom

object FavoriteRoomConverter: Converter<FavoriteRoom, Favorite> {

    override fun convert(input: FavoriteRoom): Favorite {
        return Favorite(
            _id = input.favoriteId
        )
    }

}