package com.example.gflwikiapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
//dont forget to add description later
@Parcelize
data class Tdoll(
    val name: String,
//    val description: String,
    val manufactur: String,
    val faction: String,
    val weapon: String,
    val photo: Int
): Parcelable
