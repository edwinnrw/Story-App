package id.edwinnurwansyah.telkomcase.data.entities

import com.google.gson.annotations.SerializedName
import id.edwinnurwansyah.telkomcase.domain.entities.StorySourceEntity

data class StorySourceData(
    @SerializedName("id") var id:String?="",
    @SerializedName("title") var title:String?="",
    @SerializedName("by") var createdBy:String?="",
    @SerializedName("time") var time:Long?=0,
    @SerializedName("score") var score:String?="",
    @SerializedName("kids") var comment:MutableList<String>?= mutableListOf()

)
class StoryDataEntityMapper{
    fun mapItemToEntity(item:StorySourceData) : StorySourceEntity =
        StorySourceEntity(
            id = item.id,
            title = item.title,
            createdBy = item.createdBy,
            time = item.time,
            score = item.score,
            comment = item.comment
        )
}
