package com.example.aad_playground.ut02.exercise02

import androidx.appcompat.app.AppCompatActivity
import com.example.aad_playground.R
import com.example.aad_playground.commons.Serializer
import com.example.aad_playground.ut02.repository.MemDataSource
import com.example.aad_playground.ut02.repository.SharPrefDataSource

/**
 * Clase que se encarga de crear un objeto concreto de DataSource según un identificador recibido.
 * Esta clase junto con la estructura de DataSource es lo que se conoce como Factory Pattern.
 * Es un patrón de diseño para resolver un problema común.
 */
class DataSourceFactory<T : LocalModel>(
    private val activity: AppCompatActivity,
    private val serializer: Serializer<T>
) {

    fun create(idActionClicked: Int): LocalStorage<T> {
        return when (idActionClicked) {
            R.id.action_repository_file -> FileLocalStorage(activity, serializer)
            R.id.action_repository_shapref -> SharPrefDataSource(activity, serializer)
            else -> MemDataSource()
        }
    }
}