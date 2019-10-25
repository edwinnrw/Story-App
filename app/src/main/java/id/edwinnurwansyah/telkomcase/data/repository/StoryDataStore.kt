package id.edwinnurwansyah.telkomcase.data.repository

import id.edwinnurwansyah.telkomcase.domain.entities.CommentSourceEntity
import id.edwinnurwansyah.telkomcase.domain.entities.StorySourceEntity
import io.reactivex.Observable

interface StoryDataStore {
    fun getIdTopStory() : Observable<List<String>>
    fun getDataStory(id:String?) : Observable<StorySourceEntity>
    fun getDataComment(id:String?) : Observable<CommentSourceEntity>

}