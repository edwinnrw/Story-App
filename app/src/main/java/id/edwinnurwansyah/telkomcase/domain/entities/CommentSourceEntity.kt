package id.edwinnurwansyah.telkomcase.domain.entities


data class CommentSourceEntity(
    var id:String?="",
    var createdBy:String?="",
    var text:String?="",
    var time:Long?=0
)