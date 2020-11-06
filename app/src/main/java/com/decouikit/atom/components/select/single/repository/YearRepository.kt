package com.decouikit.atom.components.select.single.repository

import io.reactivex.Observable

object YearRepository {
    fun getData(): Observable<Array<String>> {
        return Observable.just(
            arrayOf(
                "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016",
                "2017", "2018", "2019", "2020"
            )
        )
    }
}