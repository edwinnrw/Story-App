package id.edwinnurwansyah.telkomcase.domain.common

import io.reactivex.ObservableTransformer

abstract class ObservableRxTransformer <T>: ObservableTransformer<T, T>