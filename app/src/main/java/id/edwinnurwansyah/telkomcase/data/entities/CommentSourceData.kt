package id.edwinnurwansyah.telkomcase.data.entities

import com.google.gson.annotations.SerializedName
import id.edwinnurwansyah.telkomcase.domain.entities.CommentSourceEntity

data class CommentSourceData(
    @SerializedName("id") val id:String,
    @SerializedName("text") val text:String,
    @SerializedName("by") val createdBy:String,
    @SerializedName("time") val time:Long

)
class CommentDataEntityMapper{

    fun mapListToEntity(commentList:List<CommentSourceData>) : List<CommentSourceEntity> =
        commentList.map { mapItemToEntity(it) }


    private  fun mapItemToEntity(item:CommentSourceData) : CommentSourceEntity =
        CommentSourceEntity(
            id = item.id,
            createdBy = item.createdBy,
            time = item.time,
            text = item.text
        )
}
