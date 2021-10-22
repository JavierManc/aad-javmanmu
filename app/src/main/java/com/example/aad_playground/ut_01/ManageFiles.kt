package com.example.aad_playground.ut_01

import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class ManageFiles (private val activity: AppCompatActivity){

    fun createFile(fileName : String, fileText : String){
        if (fileName.isEmpty().not() || fileText.isEmpty().not()){
            val file = File(activity.filesDir, fileName)
            file.writeText(fileText)
        }
    }

    fun listFile() : MutableList<String> {
        val filesArrayList = activity.filesDir.list()
        return if (filesArrayList.isEmpty().not()){
            filesArrayList.toMutableList()
        }else{
            mutableListOf()
        }
    }

    fun readFile(file_name : String): String{
        val file = File(activity.filesDir, file_name)
        return file.readText()
    }
}