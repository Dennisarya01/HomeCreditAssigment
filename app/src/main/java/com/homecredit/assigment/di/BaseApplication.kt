package com.homecredit.assigment.di

import android.app.Activity
import android.app.Application
import com.homecredit.assigment.BuildConfig
import com.homecredit.assigment.di.component.DaggerAppComponent
import com.homecredit.assigment.di.module.AppModule
import com.homecredit.assigment.di.module.NetModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .build().inject(this )

    }
}