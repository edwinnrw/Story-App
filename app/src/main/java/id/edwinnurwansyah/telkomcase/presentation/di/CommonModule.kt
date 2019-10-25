package id.edwinnurwansyah.telkomcase.presentation.di

import dagger.Module
import dagger.Provides
import id.edwinnurwansyah.telkomcase.presentation.mapper.CommentMapper
import id.edwinnurwansyah.telkomcase.presentation.mapper.StoryMapper
import javax.inject.Singleton

@Module
class CommonModule {

    @Provides
    @Singleton
    internal fun provideMapper() : StoryMapper{
        return StoryMapper()
    }
    @Provides
    @Singleton
    internal fun provideCommentMapper() : CommentMapper{
        return CommentMapper()
    }
}