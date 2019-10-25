package id.edwinnurwansyah.telkomcase.presentation.ui.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import id.edwinnurwansyah.telkomcase.presentation.entities.Story
import kotlinx.android.synthetic.main.item_story.view.*


class StoryViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    fun bind(story: Story, context: Context){
        with(itemView){
            tvTitle.text = story.title
            tvScore.text = story.score
            tvComment.text = story.comment.size.toString() + " Comments"


        }
    }

}