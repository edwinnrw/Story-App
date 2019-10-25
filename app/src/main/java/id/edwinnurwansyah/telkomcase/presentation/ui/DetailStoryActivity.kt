package id.edwinnurwansyah.telkomcase.presentation.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.AndroidInjection
import id.edwinnurwansyah.telkomcase.R
import id.edwinnurwansyah.telkomcase.presentation.entities.Comment
import id.edwinnurwansyah.telkomcase.presentation.entities.Status
import id.edwinnurwansyah.telkomcase.presentation.entities.Story
import id.edwinnurwansyah.telkomcase.presentation.ui.adapter.CommentAdapter
import id.edwinnurwansyah.telkomcase.presentation.util.changeFormatDate
import id.edwinnurwansyah.telkomcase.presentation.util.makeGone
import id.edwinnurwansyah.telkomcase.presentation.util.makeVisible
import id.edwinnurwansyah.telkomcase.presentation.viewModel.StoryViewModel
import id.edwinnurwansyah.telkomcase.presentation.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_story.*
import javax.inject.Inject

class DetailStoryActivity : AppCompatActivity() {

    private lateinit var model:Story

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: StoryViewModel

    private lateinit var commentAdapter: CommentAdapter

    private lateinit var listComment: MutableList<Comment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_detail_story)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(StoryViewModel::class.java)

        if (savedInstanceState?.getSerializable("data") !=null){
            model = savedInstanceState.getSerializable("data") as Story
        }else{
            model = intent.getSerializableExtra("data") as Story

        }
        tvTitle.text = model.title
        tvComment.text = model.comment.size.toString()
        tvScore.text = model.score
        tvCreatedBy.text = "Created By: "+ model.created_by
        tvTime.text = changeFormatDate(model.time)
        ivFavorite.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("data",model)
            setResult(Activity.RESULT_OK, intent)
            finish()

        }
        viewModel.getCommentStory(model.comment)
        listComment = mutableListOf()
        commentAdapter = CommentAdapter(listComment,this)
        rvComment.apply {
            layoutManager= LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )
            adapter = commentAdapter
        }
        viewModel.mCommentStory.observe(this, Observer {
            when (it?.responseType) {
                Status.LOADING -> {
                    showProgress()
                    hideList()

                }
                Status.SUCCESSFUL -> {
                    hideProgress()
                    showList()
                    it.data?.let { list->
                        listComment.addAll(list)
                        commentAdapter.notifyDataSetChanged()
                    }


                }
                Status.ERROR -> {
                    hideProgress()
                    hideList()
                    Toast.makeText(this,it.error, Toast.LENGTH_LONG).show()


                }
            }
        })
    }
    private fun hideProgress() = pbComment.makeGone()

    private fun hideList() = rvComment.makeGone()


    private fun showProgress() = pbComment.makeVisible()

    private fun showList() = rvComment.makeVisible()


}
