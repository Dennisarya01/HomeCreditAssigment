package com.homecredit.assigment.di

import com.homecredit.assigment.BaseTest
import com.homecredit.assigment.di.module.NetModule
import com.homecredit.assigment.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModuleTest::class, NetModule::class, ViewModelModule::class])
interface TestAppComponent{
    fun inject(baseTest: BaseTest)
}