package com.homecredit.assigment

import com.homecredit.assigment.di.AppModuleTest
import com.homecredit.assigment.di.BaseApplication
import com.homecredit.assigment.di.DaggerTestAppComponent
import com.homecredit.assigment.di.TestAppComponent
import com.homecredit.assigment.di.module.NetModule
import com.homecredit.assigment.viewmodel.ViewModelFactory
import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import java.io.File
import javax.inject.Inject

abstract class BaseTest{
    lateinit var testAppComponent: TestAppComponent
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var mockServer: MockWebServer

    @Before
    open fun setup(){
        configureMockServer()
        configureDi()
    }

    @After
    open fun tearDown(){
        this.stopMockServer()
    }

    open fun configureDi() {
        testAppComponent = DaggerTestAppComponent.builder()
            .appModuleTest(AppModuleTest(BaseApplication()))
            .netModule(NetModule(if (isMockServerEnabled()) mockServer.url("/").toString() else BuildConfig.BASE_URL))
            .build()
        testAppComponent.inject(this)
    }

    abstract fun isMockServerEnabled():Boolean

    open fun configureMockServer(){
        if (isMockServerEnabled()){
            mockServer = MockWebServer()
            mockServer.start()
        }
    }

    open fun stopMockServer() {
        if (isMockServerEnabled()){
            mockServer.shutdown()
        }
    }

    open fun mockHttpResponse(fileName: String, responseCode: Int) = mockServer.enqueue(
        MockResponse()
        .setResponseCode(responseCode)
        .setBody(getJson(fileName)))

    private fun getJson(path : String) : String {
        val uri = this.javaClass.classLoader?.getResource(path)
        val file = File(uri?.path)
        return String(file.readBytes())
    }
}