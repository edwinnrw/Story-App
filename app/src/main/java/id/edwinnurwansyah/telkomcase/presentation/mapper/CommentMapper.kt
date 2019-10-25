package id.edwinnurwansyah.telkomcase.presentation.mapper

import id.edwinnurwansyah.telkomcase.domain.common.Mapper
import id.edwinnurwansyah.telkomcase.domain.common.MapperList
import id.edwinnurwansyah.telkomcase.domain.entities.CommentSourceEntity
import id.edwinnurwansyah.telkomcase.presentation.entities.Comment

class CommentMapper : MapperList<CommentSourceEntity, Comment>() {


    override fun mapFrom(commentList:List<CommentSourceEntity>) : List<Comment> =
        commentList.map { mapItem(it) }


    private fun mapItem(item: CommentSourceEntity): Comment =  Comment(
        id = item.id,
        text = item.text,
        createdBy = item.createdBy,
        time = item.time

    )


}