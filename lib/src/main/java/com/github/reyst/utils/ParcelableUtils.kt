@file:Suppress("unused")

package com.github.reyst.utils

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

fun Parcelable.toByteArray() = marshall(this)

fun marshall(data: Parcelable): ByteArray {
    val parcel = Parcel.obtain()
    data.writeToParcel(parcel, 0)
    val bytes = parcel.marshall()
    parcel.recycle() // not sure if needed or a good idea
    return bytes
}

fun <T : Parcelable?> unmarshall(bytes: ByteArray, creator: Creator<T>): T {
    val parcel = unmarshall(bytes)
    return creator.createFromParcel(parcel)
}

private fun unmarshall(bytes: ByteArray): Parcel {
    val parcel = Parcel.obtain()
    parcel.unmarshall(bytes, 0, bytes.size)
    parcel.setDataPosition(0) // this is extremely important!
    return parcel
}
