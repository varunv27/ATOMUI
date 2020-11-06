package com.decouikit.atom.components.cards.social_color_card.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.social_color_card.model.CardColorItem
import io.reactivex.Observable

object CardColorRepository {

    fun getData(context: Context): Observable<List<CardColorItem>> {
        val list = mutableListOf<CardColorItem>()

        list.add(
            CardColorItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                colorBg = R.color.colorCardBgDark
            )
        )
        list.add(
            CardColorItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                colorBg = R.color.colorCardBgGreen
            )
        )
        list.add(
            CardColorItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                colorBg = R.color.colorCardBgLight
            )
        )
        list.add(
            CardColorItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                colorBg = R.color.colorCardBgDark
            )
        )
        list.add(
            CardColorItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                colorBg = R.color.colorCardBgGreen
            )
        )
        list.add(
            CardColorItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                colorBg = R.color.colorCardBgLight
            )
        )

        return Observable.just(list)
    }
}