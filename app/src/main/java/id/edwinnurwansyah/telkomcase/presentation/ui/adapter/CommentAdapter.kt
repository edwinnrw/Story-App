package id.edwinnurwansyah.telkomcase.presentation.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.edwinnurwansyah.telkomcase.R
import id.edwinnurwansyah.telkomcase.presentation.entities.Comment


class CommentAdapter(private val items:MutableList<Comment>, private val context: Context) :
    RecyclerView.Adapter<CommentViewHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CommentViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(
            R.layout.item_comment, p0,
            false)
        return CommentViewHolder(view)
    }



    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(p0: CommentViewHolder, p1: Int) {
        p0.bind(items[p1],context)
    }

}