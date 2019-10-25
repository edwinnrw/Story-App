package id.edwinnurwansyah.telkomcase.presentation.entities

import java.io.Serializable

data class Comment (
    val id:String,
    val text:String,
    val createdBy:String,
    val time:Long
) : Serializable