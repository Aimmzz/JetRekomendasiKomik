package com.rohim.jetrekomendasikomik.data

import com.rohim.jetrekomendasikomik.model.DataKomik
import com.rohim.jetrekomendasikomik.model.Komik
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.Flow

class KomikRepository {
    private val komik = mutableListOf<Komik>()

    init {
        if (komik.isEmpty()) {
            DataKomik.manga.forEach {
                komik.add(Komik(it))
            }
        }
    }
    fun getAllKomik(): Flow<List<Komik>> {
        return flowOf(komik)
    }

    fun getKomikById(komikId: Long): Komik {
        return komik.first {
            it.komik.id == komikId
        }
    }

    companion object {
        @Volatile
        private var instance: KomikRepository? = null

        fun getInstance(): KomikRepository =
            instance ?: synchronized(this) {
                KomikRepository().apply {
                    instance = this
                }
            }
    }
}