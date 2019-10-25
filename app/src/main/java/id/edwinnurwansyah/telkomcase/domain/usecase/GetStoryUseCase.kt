package id.edwinnurwansyah.telkomcase.domain.usecase

import id.edwinnurwansyah.telkomcase.domain.common.BaseObservableUseCase
import id.edwinnurwansyah.telkomcase.domain.common.ObservableRxTransformer
import id.edwinnurwansyah.telkomcase.domain.entities.StorySourceEntity
import id.edwinnurwansyah.telkomcase.domain.repositories.StoryRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetStoryUseCase@Inject constructor(transformer: ObservableRxTransformer<StorySourceEntity>,
                                         private val  repository: StoryRepository
) : BaseObservableUseCase<StorySourceEntity>(transformer) {


    override fun createObservable(id: String?): Observable<StorySourceEntity> {
        return repository.getDataStory(id)
    }

    fun getDataStory(id:String) : Observable<StorySourceEntity>{
        return single(id)
    }
}