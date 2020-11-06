package com.decouikit.atom.components.splash.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.splash.model.SplashScreenViewItem
import io.reactivex.Observable

object SplashRepository {
    fun getData(context: Context): Observable<SplashScreenViewItem> {
        return Observable.just(
            SplashScreenViewItem(
                title = context.getString(R.string.splash_title),
                imgLogo = R.drawable.ic_atom_logo
            )
        )
    }
}