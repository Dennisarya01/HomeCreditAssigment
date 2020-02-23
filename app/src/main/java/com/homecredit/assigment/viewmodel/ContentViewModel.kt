package com.homecredit.assigment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.homecredit.assigment.model.ItemHomeCredit
import com.homecredit.assigment.repository.ContentRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ContentViewModel @Inject constructor(
    private val contentRepository: ContentRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val allArticle: MutableLiveData<List<ItemHomeCredit>> = MutableLiveData()
    private val allProduct: MutableLiveData<List<ItemHomeCredit>> = MutableLiveData()
    private val allContentError:MutableLiveData<String> = MutableLiveData()

    fun getAllArticle(): MutableLiveData<List<ItemHomeCredit>> = allArticle
    fun getAllProduct(): MutableLiveData<List<ItemHomeCredit>> = allProduct
    fun getContentError(): MutableLiveData<String> = allContentError

    fun getArticle() {
        compositeDisposable.add(
            contentRepository.getAllContent().subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
            ).subscribe({ allArticle.value = it.data[0].items }, {
                allContentError.value = it.message
            })
        )
    }

    fun getProduct() {
        compositeDisposable.add(
            contentRepository.getAllContent().subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
            ).subscribe({ allProduct.value = it.data[1].items }, {
                allContentError.value = it.message
            })
        )
    }


}