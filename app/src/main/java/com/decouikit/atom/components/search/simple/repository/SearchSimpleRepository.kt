package com.decouikit.atom.components.search.simple.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.search.simple.model.SearchSimpleBaseItem
import com.decouikit.atom.components.search.simple.model.SearchSimpleItem
import io.reactivex.Observable

object SearchSimpleRepository {
    fun getData(context: Context): Observable<SearchSimpleBaseItem> {
        val itemDetailsList = mutableListOf<SearchSimpleItem>()
        itemDetailsList.add(
            SearchSimpleItem(
                title = "Grant Marshall",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_2
            )
        )
        itemDetailsList.add(
            SearchSimpleItem(
                title = "Pena Valdez",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        itemDetailsList.add(
            SearchSimpleItem(
                title = "Jessica Miles",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        itemDetailsList.add(
            SearchSimpleItem(
                title = "Kerri Barber",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        itemDetailsList.add(
            SearchSimpleItem(
                title = "Natasha Gamble",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        itemDetailsList.add(
            SearchSimpleItem(
                title = "White Castaneda",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_6
            )
        )
        itemDetailsList.add(
            SearchSimpleItem(
                title = "Vanessa Ryan",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        itemDetailsList.add(
            SearchSimpleItem(
                title = "Meredith Hendricks",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_5
            )
        )
        itemDetailsList.add(
            SearchSimpleItem(
                title = "Carol Kelly",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        itemDetailsList.add(
            SearchSimpleItem(
                title = "Barrera Ramsey",
                subtitle = "Extreme coffee lover. Twitter maven. Internet practitioner. Beeraholic.",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )

        return Observable.just(
            SearchSimpleBaseItem(
                searchPlaceholder = context.getString(R.string.search_placeholder),
                viewItems = itemDetailsList
            )
        )
    }
}