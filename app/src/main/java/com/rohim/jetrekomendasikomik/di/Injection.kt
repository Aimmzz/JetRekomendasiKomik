package com.rohim.jetrekomendasikomik.di

import com.rohim.jetrekomendasikomik.data.KomikRepository

object Injection {
    fun provideRepository(): KomikRepository {
        return KomikRepository.getInstance()
    }
}