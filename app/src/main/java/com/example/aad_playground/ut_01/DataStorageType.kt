package com.example.aad_playground.ut_01

import androidx.appcompat.app.AppCompatActivity
import java.io.File

class DataStorageType(private val activity: AppCompatActivity) {

    /**
     * Fichero interno en data/data/com.example.aad-playground/files
     */
    fun privateFile() {
        val privateFile = File(activity.filesDir, "private.txt")
        privateFile.writeText("Fichero privado en el directorio de la app")
    }

    /**
     * Fichero interno en data/data/com.example.aad-playground/cache
     */
    fun privateFileCache() {
        val privateFileCache = File(activity.cacheDir, "private_cache.txt")
        privateFileCache.writeText("Fichero Cache privado")
    }

    /**
     * Fichero externo en sdcard/Android/data/com.example.aad-playground/files
     */
    fun privateExternalFile() {
        val externalFile = File(activity.getExternalFilesDir("Path_directory"), "external.txt")
        externalFile.writeText("Privado en un almacenamiento externo")
    }

    /**
     * Fichero externo en sdcard/Android/data/com.example.aad-playground/cache
     */
    fun privatExternalCacheFile() {
        val cacheExternalFile = File(activity.externalCacheDir, "cache_external_dir.txt")
        cacheExternalFile.writeText("External Cache Privado")
    }


}