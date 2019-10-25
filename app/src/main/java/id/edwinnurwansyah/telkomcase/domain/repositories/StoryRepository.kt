package id.edwinnurwansyah.telkomcase.domain.repositories

import id.edwinnurwansyah.telkomcase.domain.entities.CommentSourceEntity
import id.edwinnurwansyah.telkomcase.domain.entities.StorySourceEntity
import io.reactivex.Observable

interface StoryRepository{
    fun getIdTopStory() : Observable<List<String>>
    fun getDataStory(id:String?) : Observable<StorySourceEntity>
    fun getComment(id:String?) : Observable<List<CommentSourceEntity>>

}