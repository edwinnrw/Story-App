package id.edwinnurwansyah.telkomcase.presentation.di


import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.edwinnurwansyah.telkomcase.presentation.common.BaseViewModel
import id.edwinnurwansyah.telkomcase.presentation.viewModel.StoryViewModel
import id.edwinnurwansyah.telkomcase.presentation.viewModel.ViewModelFactory

@Module
abstract class ViewModelModule{




    @Binds
    @IntoMap
    @ViewModelKey(StoryViewModel::class)
    abstract fun bindTrendingViewModel(viewModel: StoryViewModel) : BaseViewModel

    @Binds
    abstract  fun  bindViewModelFactory(viewModelFactory: ViewModelFactory) : ViewModelProvider.Factory



}