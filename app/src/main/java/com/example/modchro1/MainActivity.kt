package com.example.modchro1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val timer = findViewById<Chronometer>(R.id.timer)

        var magic = 0L


        btnPause.isEnabled = false
        btnReset.isEnabled = false

        btnStart.setOnClickListener {
            timer.base = SystemClock.elapsedRealtime() + magic
            timer.start()
            btnStart.text = "Resume"
            btnPause.isEnabled = true
            btnReset.isEnabled = true
        }

        btnPause.setOnClickListener {
            timer.stop()
            magic = timer.base - SystemClock.elapsedRealtime()
            btnPause.isEnabled = false
        }

        btnReset.setOnClickListener {
            timer.stop()
            timer.base =  SystemClock.elapsedRealtime()
            btnStart.text = "Start"
            btnPause.isEnabled = false
            btnReset.isEnabled = false
            magic = 0L
        }

    }
}