package com.abdullah996.learning.di.application

import android.content.Context
import com.abdullah996.learning.Application
import com.abdullah996.learning.PlaceHolderDependency
import com.abdullah996.learning.di.DiConstants.APPLICATION_CONTEXT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    @Named(APPLICATION_CONTEXT)
    fun provideApplicationContext(application:Application):Context=application


    @Provides
    @Singleton
    fun providePlaceHolderDependency():PlaceHolderDependency= PlaceHolderDependency()
}