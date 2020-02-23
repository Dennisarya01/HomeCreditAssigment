package com.homecredit.assigment.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModuleTest(val app: Application){
    @Provides
    @Singleton
    fun provideApp(): Application = app
}