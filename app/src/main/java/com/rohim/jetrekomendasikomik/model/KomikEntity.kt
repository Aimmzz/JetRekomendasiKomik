package com.rohim.jetrekomendasikomik.model

data class KomikEntity(
    val id: Long,
    val title: String,
    val author: String,
    val image: Int,
    val desc: String
)