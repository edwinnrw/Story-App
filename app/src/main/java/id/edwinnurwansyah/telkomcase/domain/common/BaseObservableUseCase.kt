package id.edwinnurwansyah.telkomcase.domain.common

import io.reactivex.Observable

abstract class BaseObservableUseCase<T>(private val  transformer: ObservableRxTransformer<T>) {
    abstract fun createObservable(id: String ?= null) : Observable<T>

    fun single(id: String ?= null) : Observable<T> {
        return createObservable(id).compose(transformer)
    }

}