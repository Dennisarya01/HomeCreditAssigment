package com.homecredit.assigment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SectionHomeCredit(
    @SerializedName("section") var section:String?,
    @SerializedName("section_title") var sectionTitle:String?,
    @SerializedName("items") var items:List<ItemHomeCredit>?
): Parcelable