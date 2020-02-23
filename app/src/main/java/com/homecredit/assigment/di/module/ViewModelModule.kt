package com.homecredit.assigment.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.homecredit.assigment.viewmodel.ContentViewModel
import com.homecredit.assigment.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ContentViewModel::class)
    internal abstract fun contentViewModel(viewModel: ContentViewModel): ViewModel
}