package com.amrilhakimsihotang.submissionarchitecturecomponent.model

import android.os.Parcel
import android.os.Parcelable


data class MoviesModel(
    var original_title: String? = "",
    var poster_path: String? = "",
    var overview: String? = "",
    var director:String?="",
    var writer:String?="",
    var screenplay:String?="",
    var person_cast:String?=""

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(original_title)
        parcel.writeString(poster_path)
        parcel.writeString(overview)
        parcel.writeString(director)
        parcel.writeString(writer)
        parcel.writeString(screenplay)
        parcel.writeString(person_cast)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoviesModel> {
        override fun createFromParcel(parcel: Parcel): MoviesModel {
            return MoviesModel(parcel)
        }

        override fun newArray(size: Int): Array<MoviesModel?> {
            return arrayOfNulls(size)
        }
    }
}