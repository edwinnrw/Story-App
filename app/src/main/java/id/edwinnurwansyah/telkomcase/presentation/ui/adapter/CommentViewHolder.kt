package id.edwinnurwansyah.telkomcase.presentation.ui.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import id.edwinnurwansyah.telkomcase.presentation.entities.Comment
import id.edwinnurwansyah.telkomcase.presentation.util.changeFormatDate
import kotlinx.android.synthetic.main.item_comment.view.*


class CommentViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    fun bind(comment: Comment, context: Context){
        with(itemView){
            tvName.text = "By :"+ comment.createdBy
            tvComment.text = comment.text
            tvTime.text = changeFormatDate(comment.time)
        }
    }

}