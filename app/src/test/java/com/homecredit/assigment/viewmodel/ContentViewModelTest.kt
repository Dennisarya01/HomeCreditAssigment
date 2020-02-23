package com.homecredit.assigment.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.homecredit.assigment.BaseTest
import com.homecredit.assigment.util.RxImmediateSchedulerRule
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import java.net.HttpURLConnection
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals


@RunWith(RobolectricTestRunner::class)
class ContentViewModelTest : BaseTest() {

    @Rule
    @JvmField
    val rxTestRule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var activity: FragmentActivity
    lateinit var viewModel: ContentViewModel

    override fun isMockServerEnabled() = true
    @Before
    fun setUp() {
        super.setup()
        activity = Robolectric.setupActivity(FragmentActivity::class.java)
        viewModel = ViewModelProviders.of(activity, viewModelFactory)[ContentViewModel::class.java]

    }

    @Test
    fun getAllArticle() {
        assertEquals(null, viewModel.getAllArticle().value, "check if event still null")
        assertEquals(null, viewModel.getContentError().value, "error shoule be null")
        viewModel.getArticle()


    }

    @Test
    fun getAllProduct() {
        assertEquals(null, viewModel.getAllProduct().value, "check if event still null")
        assertEquals(null, viewModel.getContentError().value, "error shoule be null")
        viewModel.getProduct()

    }
}