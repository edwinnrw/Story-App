package id.edwinnurwansyah.telkomcase.presentation.ui.adapter


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.edwinnurwansyah.telkomcase.R
import id.edwinnurwansyah.telkomcase.presentation.entities.Story
import id.edwinnurwansyah.telkomcase.presentation.ui.DetailStoryActivity
import id.edwinnurwansyah.telkomcase.presentation.util.DETAIL_REQUEST


class StoryAdapter(private val items:MutableList<Story>, private val context: Context) :
    RecyclerView.Adapter<StoryViewHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): StoryViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(
            R.layout.item_story, p0,
            false)
        return StoryViewHolder(view)
    }



    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(p0: StoryViewHolder, p1: Int) {
        p0.bind(items[p1],context)
        p0.itemView.setOnClickListener {
            val intent = Intent(context,DetailStoryActivity::class.java)
            intent.putExtra("data",items[p1])
            (context as Activity).startActivityForResult(intent, DETAIL_REQUEST)
        }

    }

}