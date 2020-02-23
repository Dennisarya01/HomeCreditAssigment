package com.homecredit.assigment.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.homecredit.assigment.R
import com.homecredit.assigment.adapter.ArticleAdapter
import com.homecredit.assigment.adapter.ProductsAdapter
import com.homecredit.assigment.ext.hide
import com.homecredit.assigment.ext.show
import com.homecredit.assigment.model.ItemHomeCredit
import com.homecredit.assigment.viewmodel.ContentViewModel
import com.homecredit.assigment.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var contentViewModel: ContentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(R.string.app_name)

        AndroidInjection.inject(this)

        init()
    }

    private fun init() {
        contentViewModel =
            ViewModelProviders.of(this, viewModelFactory)[ContentViewModel::class.java]
        contentViewModel.getAllArticle().observe(this, Observer {
            pbLoading.show()
            if (it != null) {
                pbLoading.hide()
                initRecyclerView(it)
            }
        })

        contentViewModel =
            ViewModelProviders.of(this, viewModelFactory)[ContentViewModel::class.java]
        contentViewModel.getAllProduct().observe(this, Observer {
            pbLoading.show()
            if (it != null) {
                tvArticleSection.text = getString(R.string.article_section_title)
                pbLoading.hide()
                initRVProduct(it)
            }
        })

        contentViewModel.getContentError().observe(this, Observer {
            pbLoading.hide()
            Toast.makeText(this, "Connection Error", Toast.LENGTH_SHORT).show()
        })

        contentViewModel.getArticle()
        contentViewModel.getProduct()
    }

    private fun initRecyclerView(it: List<ItemHomeCredit>) {
        rvArticle.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvArticle.adapter = ArticleAdapter(it)
        rvArticle.isNestedScrollingEnabled = false
    }

    private fun initRVProduct(it: List<ItemHomeCredit>) {
        rvProduct.layoutManager = GridLayoutManager(this, 3)
        rvProduct.adapter = ProductsAdapter(it)
        rvProduct.isNestedScrollingEnabled = false
    }

}
