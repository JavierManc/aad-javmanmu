package com.example.aad_playground.ut03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.aad_playground.R
import com.example.aad_playground.ut03.data.AppDataBase
import com.example.aad_playground.ut03.data.UserEntity

class DataBaseActivity : AppCompatActivity() {

    private val TAG = DataBaseActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)
        initDb()
    }

    private fun initDb() {
        val db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "demo-db"
        ).build()
        
        Thread(Runnable {
            var user = db.userDao().findById(1)
            if (user == null) {
                db.userDao().insert(UserEntity(1, "name1", "username1", "email1"))
                user = db.userDao().findById(1)
            }
            Log.d(TAG, "$user")
        }).start()
    }

}