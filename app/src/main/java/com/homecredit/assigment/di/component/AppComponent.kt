package com.homecredit.assigment.di.component

import com.homecredit.assigment.di.BaseApplication
import com.homecredit.assigment.di.module.AppModule
import com.homecredit.assigment.di.module.BuildersModule
import com.homecredit.assigment.di.module.NetModule
import com.homecredit.assigment.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AppModule::class,
        BuildersModule::class,
        NetModule::class,
        ViewModelModule::class]
)
interface AppComponent {
    fun inject(app: BaseApplication)
}