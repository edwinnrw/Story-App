package id.edwinnurwansyah.telkomcase.presentation.common

import id.edwinnurwansyah.telkomcase.domain.common.ObservableRxTransformer
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AsyncObservableTransformer<T> : ObservableRxTransformer<T>() {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}