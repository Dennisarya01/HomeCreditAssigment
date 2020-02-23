package com.homecredit.assigment.repository

import com.homecredit.assigment.api.HomeCreditAPI
import com.homecredit.assigment.model.ListHomeCredit
import io.reactivex.Observable
import javax.inject.Inject

class ContentRepository @Inject constructor( val homeCreditAPI: HomeCreditAPI) {
    fun getAllContent(): Observable<ListHomeCredit> = homeCreditAPI.getContent()
}