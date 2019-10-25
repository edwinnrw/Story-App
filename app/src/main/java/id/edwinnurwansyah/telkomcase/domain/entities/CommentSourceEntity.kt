package id.edwinnurwansyah.telkomcase.domain.entities


data class CommentSourceEntity(
    val id:String,
    val createdBy:String,
    val text:String,
    val time:Long
)