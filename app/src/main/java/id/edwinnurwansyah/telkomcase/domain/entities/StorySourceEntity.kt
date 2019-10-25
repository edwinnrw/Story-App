package id.edwinnurwansyah.telkomcase.domain.entities


data class StorySourceEntity(
    val id:String,
    val title:String,
    val createdBy:String,
    val time:Long,
    val score:String,
    val comment:MutableList<String>
)