package id.edwinnurwansyah.telkomcase.presentation.di

import dagger.Module
import dagger.Provides
import id.edwinnurwansyah.telkomcase.data.api.RemoteApi
import id.edwinnurwansyah.telkomcase.data.repository.StoryRemote
import id.edwinnurwansyah.telkomcase.data.repository.StoryRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    internal fun provideTrendingRemote(remoteApi: RemoteApi): StoryRemote {
        return StoryRemote(remoteApi)

    }

    @Singleton
    @Provides
    internal fun provideGithubRepository(storyRemote: StoryRemote): StoryRepository {
        return StoryRepository(storyRemote)
    }
}