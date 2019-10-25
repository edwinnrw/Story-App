package id.edwinnurwansyah.telkomcase.presentation.mapper

import id.edwinnurwansyah.telkomcase.domain.common.Mapper
import id.edwinnurwansyah.telkomcase.domain.entities.StorySourceEntity
import id.edwinnurwansyah.telkomcase.presentation.entities.Story

class StoryMapper : Mapper<StorySourceEntity, Story>() {
    override fun mapFrom(item: StorySourceEntity): Story =  Story(
        id = item.id?:"",
        title = item.title?:"",
        created_by = item.createdBy?:"",
        time = item.time?:0,
        score = item.score?:"",
        comment = item.comment?: mutableListOf()
    )


}