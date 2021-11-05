package com.example.aad_playground

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.aad_playground.ut_01.ManageFiles

class MainActivity(private val activity: AppCompatActivity) : AppCompatActivity() {

    lateinit var inputNameFile: AppCompatEditText
    lateinit var inputContentFile: AppCompatEditText
    lateinit var actionSave: AppCompatButton
    lateinit var actionExplorer: AppCompatButton
    lateinit var viewerFiles: TextView
    lateinit var inputNameFileSelected: AppCompatEditText
    lateinit var actionShowContent: AppCompatButton
    lateinit var viewerFileContent: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manageFiles = ManageFiles(this)

        inputNameFile = findViewById(R.id.input_name_file)
        inputContentFile = findViewById(R.id.input_content_file)
        actionSave = findViewById(R.id.action_save)
        actionSave.setOnClickListener {
            manageFiles.createFile(inputNameFile.text.toString(), inputContentFile.text.toString())
        }
        viewerFiles = findViewById(R.id.viewer_files)
        actionExplorer = findViewById(R.id.action_explorer)
        actionExplorer.setOnClickListener {
            manageFiles.listFile().forEach { res ->
                viewerFiles.setText(viewerFiles.text.toString() + "~$res" + "\n")
            }
        }
        inputNameFileSelected = findViewById(R.id.input_name_file_selected)
        viewerFileContent = findViewById(R.id.text_file_content)
        actionShowContent = findViewById(R.id.action_show_content)
        actionShowContent.setOnClickListener {
            viewerFileContent.setText(manageFiles.readFile(inputNameFileSelected.text.toString()))
        }

    }
}