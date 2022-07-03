package com.abdullah996.learning.di.activity

import android.app.Activity
import android.content.Context
import androidx.core.app.ActivityCompat
import com.abdullah996.learning.Application
import com.abdullah996.learning.di.DiConstants.ACTIVITY_CONTEXT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {


    @Provides
    @Named(ACTIVITY_CONTEXT)
    fun provideActivityContext(activity:Activity): Context =activity
}