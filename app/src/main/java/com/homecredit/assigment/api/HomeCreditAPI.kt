package com.homecredit.assigment.api

import com.homecredit.assigment.model.ListHomeCredit
import io.reactivex.Observable

import retrofit2.http.GET

interface HomeCreditAPI {

    @GET("home")
    fun getContent(): Observable<ListHomeCredit>

}