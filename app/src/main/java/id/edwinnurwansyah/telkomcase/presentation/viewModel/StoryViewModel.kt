package id.edwinnurwansyah.telkomcase.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import id.edwinnurwansyah.telkomcase.presentation.common.BaseViewModel
import id.edwinnurwansyah.telkomcase.domain.usecase.GetCommentStoryUseCase
import id.edwinnurwansyah.telkomcase.domain.usecase.GetStoryUseCase
import id.edwinnurwansyah.telkomcase.domain.usecase.GetIdTopStoryUseCase
import id.edwinnurwansyah.telkomcase.presentation.entities.Comment
import id.edwinnurwansyah.telkomcase.presentation.entities.Data
import id.edwinnurwansyah.telkomcase.presentation.entities.Status
import id.edwinnurwansyah.telkomcase.presentation.entities.Story
import id.edwinnurwansyah.telkomcase.presentation.mapper.CommentMapper
import id.edwinnurwansyah.telkomcase.presentation.mapper.StoryMapper
import io.reactivex.Observable
import javax.inject.Inject

class StoryViewModel @Inject constructor(private val  remoteUseCaseIdTop: GetIdTopStoryUseCase,
                                         private val  remoteUseCaseStory: GetStoryUseCase,
                                         private val  remoteUseCaseComment: GetCommentStoryUseCase,
                                         private val commentMapper: CommentMapper,
                                         private val mapper: StoryMapper) : BaseViewModel(){

    var mTopStory = MutableLiveData<Data<List<Story>>>()
    var mCommentStory = MutableLiveData<Data<List<Comment>>>()

    fun fetchTopStory(){
        val listIdTop = mutableListOf<String>()
        val listTopStory = mutableListOf<Story>()

        val topObservable = remoteUseCaseIdTop.getIdTop().replay()
        val disposableTop = topObservable
            .doOnSubscribe {
                mTopStory.postValue(Data(responseType = Status.LOADING))

            }
            .subscribe({ response->
                listIdTop.addAll(response)

            },{
                    error ->
                mTopStory.postValue(Data(responseType = Status.ERROR,error = error.message))

            })
        addDisposable(
            disposableTop
        )
        val disposableTopStory = topObservable
            .flatMap {
                return@flatMap Observable.fromIterable(it)
            }
            .flatMap {
                return@flatMap remoteUseCaseStory.getDataStory("$it.json")
            }
            .flatMap { mapper.observable(it) }
            .subscribe(
                { response->
                    listTopStory.add(response)
                    mTopStory.postValue(Data(responseType = Status.SUCCESSFUL,data = listTopStory))

                },
                {
                    error ->


                    if(listTopStory.size>0){
                        mTopStory.postValue(Data(responseType = Status.SUCCESSFUL,data = listTopStory,error = error.message))

                    }else if (listTopStory.size != listIdTop.size){
                        mTopStory.postValue(Data(responseType = Status.ERROR,error = error.message))
                    }
                },
                {
                    mTopStory.postValue(Data(responseType = Status.SUCCESSFUL,data = listTopStory))
                }
            )
        addDisposable(
            disposableTopStory
        )

        topObservable.connect()



    }
    fun getCommentStory(id:List<String>){
        val listComment = mutableListOf<Comment>()

        val disposableTop = Observable.fromIterable(id).flatMap {
            remoteUseCaseComment.getComment("$it.json")
        }.flatMap { commentMapper.observable(it) }
            .doOnSubscribe {
                mCommentStory.postValue(Data(responseType = Status.LOADING))

            }
            .subscribe({ response->
                listComment.add(response)

            },{
                    error ->
                mCommentStory.postValue(Data(responseType = Status.ERROR,error = error.message))

            },{
                mCommentStory.postValue(Data(responseType = Status.SUCCESSFUL,data = listComment))
            })
        addDisposable(
            disposableTop
        )
    }

}