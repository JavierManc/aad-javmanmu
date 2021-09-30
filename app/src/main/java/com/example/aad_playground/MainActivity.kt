package com.example.aad_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aad_playground.ut_01.FilePlayGround

class MainActivity : AppCompatActivity() {

    val colors : MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initColors()
        val filePlayGround = FilePlayGround(this)
        filePlayGround.saveToFile(colors)
        val lst = filePlayGround.readFromFile()
        readColors(lst)
    }

    private fun initColors(){
        colors.add("Blue")
        colors.add("Red")
        colors.add("Orange")
        colors.add("Green")
    }

    /**
     * Método que lee una lista y la muestra por logcat
     */
    private fun readColors(colors : MutableList<String>){
        colors.forEach {
            Log.d("@dev", it)
        }
    }
}