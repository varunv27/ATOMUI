package com.decouikit.atom.components.select.single.repository

import io.reactivex.Observable

object CityRepository {
    fun getData(): Observable<Array<String>> {
        return Observable.just(
            arrayOf(
                "USA", "France", "Netherlands", "GothamLand"
            )
        )
    }
}