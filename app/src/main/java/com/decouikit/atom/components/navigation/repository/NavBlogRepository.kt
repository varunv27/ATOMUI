package com.decouikit.atom.components.navigation.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.navigation.model.NavBlogItem
import io.reactivex.Observable

object NavBlogRepository {

    fun getData(context: Context): Observable<List<NavBlogItem>> {
        val list = mutableListOf<NavBlogItem>()

        list.add(
            NavBlogItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                colorBg = R.color.colorCardBgDark
            )
        )
        list.add(
            NavBlogItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                colorBg = R.color.colorCardBgGreen
            )
        )
        list.add(
            NavBlogItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                colorBg = R.color.colorCardBgLight
            )
        )
        list.add(
            NavBlogItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                colorBg = R.color.colorCardBgDark
            )
        )
        list.add(
            NavBlogItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                colorBg = R.color.colorCardBgGreen
            )
        )
        list.add(
            NavBlogItem(
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