package com.decouikit.atom.components.select.single.repository

import io.reactivex.Observable

object MonthRepository {
    fun getData(): Observable<Array<String>> {
        return Observable.just(
            arrayOf(
                "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"
            )
        )
    }
}