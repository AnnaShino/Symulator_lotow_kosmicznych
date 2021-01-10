package com.example.projekt

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_widok_7.*
import kotlin.system.exitProcess

class widok_7 : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFeatureInt(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        this.supportActionBar!!.hide()
        setContentView(R.layout.activity_widok_7)

        var button1 = findViewById<Button>(R.id.button12)
        button1.setOnClickListener {
            val popup = PopupMenu(this,button1)
            popup.inflate(R.menu.predkosc)
            popup.setOnMenuItemClickListener {
                Toast.makeText(this, it.tooltipText, Toast.LENGTH_LONG).show()
                true
            }
            popup.show()

        }
    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()

            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            startActivity(intent)
            finish()
            exitProcess(0)

            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Kliknij przycisk POWRÓT ponownie aby wyjść z aplikacji", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)

    }

    fun nextStep(view: View?) {

        var nazwa_rakiety = intent.getStringExtra("nazwa_rakiety")
        var planeta: Int = intent.getIntExtra("planeta", 0)
        var zaloga:Int = intent.getIntExtra("zaloga", 0)
        var leki:Int = intent.getIntExtra("leki", 0)
        var jedzenie = intent.getIntExtra("jedzenie",0)

        var szybkosc: String = Text.text.toString()


        if(szybkosc.isEmpty()) {
            Toast.makeText(this, "Nie wpisano szybkości rakiety...", Toast.LENGTH_SHORT).show()
        }

        else {
        val na = Intent(this, widok_8::class.java)
            na.putExtra("zaloga", zaloga)
            na.putExtra("nazwa_rakiety", nazwa_rakiety)
            na.putExtra("planeta", planeta)
            na.putExtra("leki", leki)
            na.putExtra("jedzenie", jedzenie)
            na.putExtra("szybkosc", szybkosc.toInt())
            startActivity(na)
            this.finish()

    }
}}
