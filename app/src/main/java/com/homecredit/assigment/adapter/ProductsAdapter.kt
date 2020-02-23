package com.homecredit.assigment.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homecredit.assigment.R
import com.homecredit.assigment.model.ItemHomeCredit
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_product.view.*


class ProductsAdapter(val itemList: List<ItemHomeCredit>) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_product,
                parent,
                false
            )
        )


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: ItemHomeCredit) {

            Picasso.get().load(item.productImage).into(itemView.ivProduct)
            itemView.tvProduct.text = item.productName

            val url = item.link

            itemView.llProduct.setOnClickListener{
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                itemView.context.startActivity(i)
            }
        }
    }
}