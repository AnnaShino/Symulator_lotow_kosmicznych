package com.example.projekt

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileInputStream
import kotlin.system.exitProcess


class widok_16 : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFeatureInt(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        this.supportActionBar!!.hide()
        setContentView(R.layout.activity_widok_16)
        val button = findViewById<Button>(R.id.btt)


        var plik_zapisu = filesDir
        val rankingi = File(plik_zapisu, "ranking")
        val pokaz = FileInputStream(rankingi).bufferedReader().use { it.readText() }.toString()

        val textView: TextView = findViewById<Button>(R.id.textView8)
        textView.movementMethod = ScrollingMovementMethod()
        textView.text = pokaz
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
    fun onclick(view: View) {
        val na = Intent(this, widok_14::class.java)
        startActivity(na)
        this.finish()
    }
}
