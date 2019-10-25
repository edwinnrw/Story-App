package id.edwinnurwansyah.telkomcase.domain.common

import io.reactivex.Observable

abstract class Mapper <in T,E>{
    abstract fun mapFrom(from: T): E

    fun observable(from: T) = Observable.fromCallable { mapFrom(from) }


}