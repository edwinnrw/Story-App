package id.edwinnurwansyah.telkomcase.data.entities

import com.google.gson.annotations.SerializedName
import id.edwinnurwansyah.telkomcase.domain.entities.CommentSourceEntity

data class CommentSourceData(
    @SerializedName("id") var id:String?="",
    @SerializedName("text") var text:String?="",
    @SerializedName("by") var createdBy:String?="",
    @SerializedName("time") var time:Long?=0

)
class CommentDataEntityMapper{


    fun mapItemToEntity(item:CommentSourceData) : CommentSourceEntity =
        CommentSourceEntity(
            id = item.id,
            createdBy = item.createdBy,
            time = item.time,
            text = item.text
        )
}
