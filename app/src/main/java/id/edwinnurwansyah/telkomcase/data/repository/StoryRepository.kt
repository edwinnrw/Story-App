package id.edwinnurwansyah.telkomcase.data.repository

import id.edwinnurwansyah.telkomcase.domain.entities.CommentSourceEntity
import id.edwinnurwansyah.telkomcase.domain.entities.StorySourceEntity
import id.edwinnurwansyah.telkomcase.domain.repositories.StoryRepository
import io.reactivex.Observable

class StoryRepository(private val  remote: StoryRemote) : StoryRepository {
    override fun getComment(id: String?): Observable<CommentSourceEntity> {
        return remote.getDataComment(id)
    }

    override fun getDataStory(id: String?): Observable<StorySourceEntity> {
        return remote.getDataStory(id)
    }


    override fun getIdTopStory(): Observable<List<String>> {
        return remote.getIdTopStory()
    }
}