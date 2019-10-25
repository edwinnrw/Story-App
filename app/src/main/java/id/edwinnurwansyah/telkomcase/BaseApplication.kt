package id.edwinnurwansyah.telkomcase

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import id.edwinnurwansyah.telkomcase.presentation.di.DaggerAppComponent
import javax.inject.Inject


class BaseApplication : Application(), HasAndroidInjector {
    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>


    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }


}