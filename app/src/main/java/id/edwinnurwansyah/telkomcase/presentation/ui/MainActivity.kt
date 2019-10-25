package id.edwinnurwansyah.telkomcase.presentation.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import dagger.android.AndroidInjection
import id.edwinnurwansyah.telkomcase.R
import id.edwinnurwansyah.telkomcase.presentation.entities.Status
import id.edwinnurwansyah.telkomcase.presentation.entities.Story
import id.edwinnurwansyah.telkomcase.presentation.ui.adapter.StoryAdapter
import id.edwinnurwansyah.telkomcase.presentation.util.DETAIL_REQUEST
import id.edwinnurwansyah.telkomcase.presentation.util.makeGone
import id.edwinnurwansyah.telkomcase.presentation.util.makeVisible
import id.edwinnurwansyah.telkomcase.presentation.viewModel.StoryViewModel
import id.edwinnurwansyah.telkomcase.presentation.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: StoryViewModel

    private lateinit var storyAdapter: StoryAdapter

    private lateinit var listStory: MutableList<Story>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(StoryViewModel::class.java)
        viewModel.fetchTopStory()
        listStory = mutableListOf()
        storyAdapter = StoryAdapter(listStory,this)
        rvStory.apply {
            layoutManager= GridLayoutManager(this@MainActivity, 2)
            adapter = storyAdapter
        }
        viewModel.mTopStory.observe(this, Observer {
            when (it?.responseType) {
                Status.LOADING -> {
                    showProgress()

                }
                Status.SUCCESSFUL -> {
                    hideProgress()
                    it.data?.let { list->
                        listStory.addAll(list)
                        storyAdapter.notifyDataSetChanged()
                    }


                }
                Status.ERROR -> {
                    hideProgress()
                    Toast.makeText(this,it.error,Toast.LENGTH_LONG).show()


                }
            }
        })

    }
    private fun hideProgress() = pbStory.makeGone()

    private fun showProgress() = pbStory.makeVisible()

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == DETAIL_REQUEST && resultCode == Activity.RESULT_OK){
            val favorite = data?.getSerializableExtra("data") as Story
            tvFavoriteTitle.text = favorite.title
            clFavorite.visibility = View.VISIBLE
        }else{
            clFavorite.visibility = View.GONE

        }
    }
}
