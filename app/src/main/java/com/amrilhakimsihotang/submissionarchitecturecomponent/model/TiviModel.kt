package com.amrilhakimsihotang.submissionarchitecturecomponent.model

import android.os.Parcel
import android.os.Parcelable

data class TiviModel(
    var original_name: String? = "",
    var poster_path: String? = "",
    var overview: String? = "",
    var creatorcast: String?="",
    var seriescast: String?="",
    var writingcast:String?=""
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(original_name)
        parcel.writeString(poster_path)
        parcel.writeString(overview)
        parcel.writeString(creatorcast)
        parcel.writeString(seriescast)
        parcel.writeString(writingcast)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TiviModel> {
        override fun createFromParcel(parcel: Parcel): TiviModel {
            return TiviModel(parcel)
        }

        override fun newArray(size: Int): Array<TiviModel?> {
            return arrayOfNulls(size)
        }
    }
}