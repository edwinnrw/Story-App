package id.edwinnurwansyah.telkomcase.presentation.di

import dagger.Module
import dagger.Provides
import id.edwinnurwansyah.telkomcase.presentation.common.AsyncObservableTransformer
import id.edwinnurwansyah.telkomcase.data.repository.StoryRepository
import id.edwinnurwansyah.telkomcase.domain.usecase.GetCommentStoryUseCase
import id.edwinnurwansyah.telkomcase.domain.usecase.GetStoryUseCase
import id.edwinnurwansyah.telkomcase.domain.usecase.GetIdTopStoryUseCase

@Module
class UseCaseModule {

    @Provides
    internal fun provideUseCaseStory(repository: StoryRepository): GetStoryUseCase{
        return GetStoryUseCase(AsyncObservableTransformer(), repository)

    }
    @Provides
    internal fun provideUseCaseTopStory(repository: StoryRepository): GetIdTopStoryUseCase{
        return GetIdTopStoryUseCase(AsyncObservableTransformer(), repository)

    }
    @Provides
    internal fun provideUseCaseCommentStory(repository: StoryRepository): GetCommentStoryUseCase{
        return GetCommentStoryUseCase(AsyncObservableTransformer(), repository)

    }
}