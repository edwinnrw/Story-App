package id.edwinnurwansyah.telkomcase.domain.usecase

import id.edwinnurwansyah.telkomcase.domain.common.BaseObservableUseCase
import id.edwinnurwansyah.telkomcase.domain.common.ObservableRxTransformer
import id.edwinnurwansyah.telkomcase.domain.entities.CommentSourceEntity
import id.edwinnurwansyah.telkomcase.domain.repositories.StoryRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCommentStoryUseCase@Inject constructor(transformer: ObservableRxTransformer<List<CommentSourceEntity>>,
                                                private val  repository: StoryRepository
) : BaseObservableUseCase<List<CommentSourceEntity>>(transformer) {
    override fun createObservable(id: String?): Observable<List<CommentSourceEntity>> {
        return repository.getComment(id)
    }

    fun getComment(id: String?) : Observable<List<CommentSourceEntity>>{
        return single(id)
    }
}