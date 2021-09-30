package com.example.aad_playground.ut_01

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.File

/**
 *
 */
class FilePlayGround(private val activity: AppCompatActivity) {
    /**
    Función que se ejecuta al instanciar la clase (crear un objeto)
     */
    init {
        //createFile()
        //writeFile()
        //appendText()
        //appendTextWithNewLine()
        //readFile()
        //readLineByLine()
        //deleteFile()

    }

    /**
    Función para crear ficheros. FilesDir te lleva a la ruta del fichero en android
     */
    fun createFile() {
        val file = File(activity.filesDir, "aad.txt")
        //Log.d("@dev", activity.filesDir.absolutePath)
    }

    fun writeFile() {
        val file = File(activity.filesDir, "aad.txt")
        file.writeText("Hola Acceso a Datos")
    }

    fun readFile() {
        val file = File(activity.filesDir, "aad.txt")
        val line = file.readText()
        Log.d("@dev", line)
    }

    fun appendText() {
        val file = File(activity.filesDir, "aad.txt")
        file.appendText("Hola1")
        file.appendText("Hola2")
        file.appendText("Hola3")
        file.appendText("Hola4")
    }

    fun appendTextWithNewLine() {
        val file = File(activity.filesDir, "aad.txt")
        file.appendText("\n")
        file.appendText("Adios1")
        file.appendText("\n")
        file.appendText("Adios2")
    }

    fun readLineByLine() {
        val file = File(activity.filesDir, "aad.txt")
        file.writeText("Linea 1")
        file.appendText("\n")
        file.appendText("Linea 2")
        file.appendText("\n")
        file.appendText("Linea 3")

        val lines: List<String> = file.readLines()
        lines.forEach {
            Log.d("@dev", it)
        }
    }

    fun deleteFile() {
        val file = File(activity.filesDir, "aad.txt")
        if (file.exists()) {
            file.delete()
        }
    }

    /**
     * Método que escribe la lista de colores en un fichero
     */
    fun saveToFile(colors: MutableList<String>) {
        val file = File(activity.filesDir, "colors.txt")

        if (file.exists().not()) {
            colors.forEach {
                file.appendText(it)
                file.appendText("\n")
            }
        }
    }

    /**
     * Método que lee el fichero y devuelve una lista mutable con el contenido del fichero
     */
    fun readFromFile(): MutableList<String> {
        val file = File(activity.filesDir, "colors.txt")
        return file.readLines().toMutableList()
    }
}