package id.edwinnurwansyah.telkomcase.data.entities

import com.google.gson.annotations.SerializedName
import id.edwinnurwansyah.telkomcase.domain.entities.StorySourceEntity

data class StorySourceData(
    @SerializedName("id") val id:String,
    @SerializedName("title") val title:String,
    @SerializedName("by") val createdBy:String,
    @SerializedName("time") val time:Long,
    @SerializedName("score") val score:String,
    @SerializedName("kids") val comment:MutableList<String>

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
