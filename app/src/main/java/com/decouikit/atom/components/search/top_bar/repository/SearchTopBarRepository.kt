package com.decouikit.atom.components.search.top_bar.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.search.top_bar.model.SearchTopBarBaseItem
import com.decouikit.atom.components.search.top_bar.model.SearchTopBarItem
import io.reactivex.Observable

object SearchTopBarRepository {

    fun getData(context: Context): Observable<SearchTopBarBaseItem> {
        val itemDetailsList = mutableListOf<SearchTopBarItem>()
        itemDetailsList.add(
            SearchTopBarItem(
                title = "Grant Marshall",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_2
            )
        )
        itemDetailsList.add(
            SearchTopBarItem(
                title = "Pena Valdez",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        itemDetailsList.add(
            SearchTopBarItem(
                title = "Jessica Miles",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        itemDetailsList.add(
            SearchTopBarItem(
                title = "Kerri Barber",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        itemDetailsList.add(
            SearchTopBarItem(
                title = "Natasha Gamble",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        itemDetailsList.add(
            SearchTopBarItem(
                title = "White Castaneda",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_6
            )
        )
        itemDetailsList.add(
            SearchTopBarItem(
                title = "Vanessa Ryan",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        itemDetailsList.add(
            SearchTopBarItem(
                title = "Meredith Hendricks",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_5
            )
        )
        itemDetailsList.add(
            SearchTopBarItem(
                title = "Carol Kelly",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        itemDetailsList.add(
            SearchTopBarItem(
                title = "Barrera Ramsey",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )

        return Observable.just(
            SearchTopBarBaseItem(
                searchPlaceholder = context.getString(R.string.search_placeholder),
                viewItems = itemDetailsList
            )
        )
    }
}