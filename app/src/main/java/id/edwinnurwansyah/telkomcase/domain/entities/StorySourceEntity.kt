package id.edwinnurwansyah.telkomcase.domain.entities


data class StorySourceEntity(
    var id:String?="",
    var title:String?="",
    var createdBy:String?="",
    var time:Long?=0,
    var score:String?="",
    var comment:MutableList<String>?= mutableListOf()
)