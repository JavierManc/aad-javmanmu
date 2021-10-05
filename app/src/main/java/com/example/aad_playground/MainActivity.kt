package com.example.aad_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.aad_playground.ut_01.DataStorageType
import com.example.aad_playground.ut_01.FilePlayGround
import com.example.aad_playground.ut_01.ManageFiles
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var inputNameFile : AppCompatEditText
    lateinit var inputContentFile : AppCompatEditText
    lateinit var actionSave : AppCompatButton
    lateinit var actionExplorer : AppCompatButton
    lateinit var viewerFiles : TextView


    //val colors : MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        initColors()
        val filePlayGround = FilePlayGround(this)
        filePlayGround.saveToFile(colors)
        val lst = filePlayGround.readFromFile()
        readColors(lst)
        */

        //val dataStorageType = DataStorageType(this)
        //dataStorageType.privateFile()
        //dataStorageType.privateFileCache()
        //dataStorageType.privateExternalFile()
        //dataStorageType.privatExternalCacheFile()

        val manageFiles = ManageFiles(this)

        inputNameFile = findViewById(R.id.input_name_file)
        inputContentFile = findViewById(R.id.input_content_file)
        actionSave = findViewById(R.id.action_save)
        actionSave.setOnClickListener {
            manageFiles.createFile(inputNameFile.text.toString(), inputContentFile.text.toString())
        }
        viewerFiles = findViewById(R.id.action_explorer)
        actionExplorer = findViewById(R.id.action_explorer)

    }

    /**
     * Incompleto
     */
    private fun readFiles(files : MutableList<String>){

        Thread (Runnable {
            files.forEach {
                runOnUiThread{
                    //viewerFiles.setText(viewerFiles.text.toString() + files.get(it) + "\n")
                }
            }
        })
    }
    /*
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
    */

}