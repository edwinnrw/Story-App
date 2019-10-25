package id.edwinnurwansyah.telkomcase.data.api

import id.edwinnurwansyah.telkomcase.data.entities.CommentSourceData
import id.edwinnurwansyah.telkomcase.data.entities.StorySourceData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {
    @GET("topstories.json")
    fun getIdTopStory() : Observable<List<String>>

    @GET("item/{id}")
    fun getStoryItem(@Path("id") id:String?="") : Observable<StorySourceData>


    @GET("item/{id}")
    fun getComment(@Path("id") id:String?="") : Observable<CommentSourceData>
}