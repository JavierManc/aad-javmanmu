package com.example.aad_playground.ut03.ex06.data

import com.example.aad_playground.ut03.ex06.data.remote.RemoteDataSource
import com.example.aad_playground.ut03.ex06.domain.TapaModel
import com.example.aad_playground.ut03.ex06.domain.TapaRepository

class TapaDataRepository(val remoteDataSource: RemoteDataSource) : TapaRepository {

    /**
     * Obtiene un listado de tapas.
     * Se consulta en local, si existe un listado de tapas se devuelve, sino, se obtiene de remoto,
     * se guarda en local y se devuelve.
     */
    override fun fetchTapas(): Result<List<TapaModel>> {
        return remoteDataSource.getTapas()
    }

    /**
     * Obtiene una tapa y se guarda en local
     * Se consulta en local, si existe la tapa se devuelve, sino, se obtiene de remoto,
     * se guarda en local y se devuelve.
     */
    override fun fetchTapa(tapaId: String): Result<TapaModel> {
        return remoteDataSource.getTapa(tapaId)
    }
}