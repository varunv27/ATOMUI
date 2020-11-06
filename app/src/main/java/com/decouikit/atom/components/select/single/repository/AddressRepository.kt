package com.decouikit.atom.components.select.single.repository

import io.reactivex.Observable

object AddressRepository {
    fun getData() : Observable<List<String>> {
        val list = mutableListOf<String>()
        list.add("222 Duffield Street")
        list.add("198 Clark Street")
        list.add("588 Kenmore Terrace")
        return Observable.just(list)
    }
}