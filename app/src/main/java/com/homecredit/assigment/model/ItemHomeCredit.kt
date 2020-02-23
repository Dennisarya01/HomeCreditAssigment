package com.homecredit.assigment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class ItemHomeCredit(
    @SerializedName("article_title") var articleTitle: String?,
    @SerializedName("article_image") var articleImage: String?,
    @SerializedName("link") var link: String?,
    @SerializedName("product_name") var productName: String?,
    @SerializedName("product_image") var productImage: String?
) : Parcelable
