package id.edwinnurwansyah.telkomcase.data.repository

import id.edwinnurwansyah.telkomcase.data.api.RemoteApi
import id.edwinnurwansyah.telkomcase.data.entities.CommentDataEntityMapper
import id.edwinnurwansyah.telkomcase.data.entities.StoryDataEntityMapper
import id.edwinnurwansyah.telkomcase.domain.entities.CommentSourceEntity
import id.edwinnurwansyah.telkomcase.domain.entities.StorySourceEntity
import io.reactivex.Observable

class StoryRemote(private val api:RemoteApi) : StoryDataStore {

    private val storyMapper = StoryDataEntityMapper()
    private val commentMapper = CommentDataEntityMapper()

    override fun getDataComment(id: String?): Observable<CommentSourceEntity> {
        return api.getComment(id).map { commentMapper.mapItemToEntity(it) }
    }


    override fun getDataStory(id:String?): Observable<StorySourceEntity> {
        return api.getStoryItem(id).map { storyMapper.mapItemToEntity(it) }
    }

    override fun getIdTopStory(): Observable<List<String>> {
       return api.getIdTopStory()
    }
}