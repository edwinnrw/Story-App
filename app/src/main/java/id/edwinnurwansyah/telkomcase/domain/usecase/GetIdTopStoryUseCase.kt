package id.edwinnurwansyah.telkomcase.domain.usecase

import id.edwinnurwansyah.telkomcase.domain.common.BaseObservableUseCase
import id.edwinnurwansyah.telkomcase.domain.common.ObservableRxTransformer
import id.edwinnurwansyah.telkomcase.domain.repositories.StoryRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetIdTopStoryUseCase@Inject constructor(transformer: ObservableRxTransformer<List<String>>,
                                              private val  repository: StoryRepository
) : BaseObservableUseCase<List<String>>(transformer) {
    override fun createObservable(id: String?): Observable<List<String>> {
        return repository.getIdTopStory()
    }

    fun getIdTop() : Observable<List<String>>{
        return single()
    }
}