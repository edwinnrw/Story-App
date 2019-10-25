package id.edwinnurwansyah.telkomcase.presentation.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.edwinnurwansyah.telkomcase.presentation.ui.DetailStoryActivity
import id.edwinnurwansyah.telkomcase.presentation.ui.MainActivity

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun detailActivity(): DetailStoryActivity

}