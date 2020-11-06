package com.decouikit.atom.components.wizard.profile.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WizardProfileItem(
    val title: String,
    val subtitle: String,
    val avatarUrl: String? = "",
    @DrawableRes val avatarDrawableRes: Int? = -1
) : Parcelable