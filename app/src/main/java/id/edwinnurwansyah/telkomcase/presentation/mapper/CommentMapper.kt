package id.edwinnurwansyah.telkomcase.presentation.mapper

import id.edwinnurwansyah.telkomcase.domain.common.Mapper
import id.edwinnurwansyah.telkomcase.domain.entities.CommentSourceEntity
import id.edwinnurwansyah.telkomcase.presentation.entities.Comment

class CommentMapper : Mapper<CommentSourceEntity, Comment>() {


    override fun mapFrom(item: CommentSourceEntity): Comment =  Comment(
        id = item.id,
        text = item.text,
        createdBy = item.createdBy,
        time = item.time

    )


}