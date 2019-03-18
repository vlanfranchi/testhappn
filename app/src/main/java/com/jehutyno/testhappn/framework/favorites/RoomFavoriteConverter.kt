package com.jehutyno.testhappn.framework.favorites

import com.jehutyno.domain.model.Favorite
import com.jehutyno.testhappn.Converter
import com.jehutyno.testhappn.database.favorites.FavoriteRoom

object RoomFavoriteConverter: Converter<Favorite, FavoriteRoom> {

    override fun convert(input: Favorite): FavoriteRoom {
        return FavoriteRoom(
            favoriteId = input.article
        )
    }

}