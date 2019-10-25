package id.edwinnurwansyah.telkomcase.presentation.entities

import java.io.Serializable

data class Story (
    val id:String,
    val title:String,
    val created_by:String,
    val time:Long,
    val score:String,
    val comment:MutableList<String>
) : Serializable