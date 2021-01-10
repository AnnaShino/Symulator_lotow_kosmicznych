package com.example.projekt

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_widok_3.*
import kotlin.system.exitProcess


class widok_3 : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        window.setFeatureInt(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        this.supportActionBar!!.hide()
        setContentView(R.layout.activity_widok_3)

        var button1 = findViewById<Button>(R.id.button6)
        button1.setOnClickListener {
            val popup = PopupMenu(this,button1)
            popup.inflate(R.menu.planety)
            popup.setOnMenuItemClickListener {
                Toast.makeText(this, it.tooltipText, Toast.LENGTH_LONG).show()
                true
            }
            popup.show()


    }}

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
        val nazwa_rakiety = intent.getStringExtra("nazwa_rakiety")

        val wybór1 = findViewById<View>(R.id.planeta1)
        val wybór2 = findViewById<View>(R.id.planeta2)
        val wybór3 = findViewById<View>(R.id.planeta3)
        val wybór4 = findViewById<View>(R.id.planeta4)
        val wybór5 = findViewById<View>(R.id.planeta5)
        val wybór6 = findViewById<View>(R.id.planeta6)
        val wybór7 = findViewById<View>(R.id.planeta7)
        val wybór8 = findViewById<View>(R.id.planeta8)
        val wybór9 = findViewById<View>(R.id.planeta9)


        if (planeta1.isPressed){
            val na = Intent(this, widok_4::class.java)
            na.putExtra("nazwa_rakiety", nazwa_rakiety)
            na.putExtra("planeta", 1)
            startActivity(na)}

        if (planeta2.isPressed){
            val na = Intent(this, widok_4::class.java)
            na.putExtra("nazwa_rakiety", nazwa_rakiety)
            na.putExtra("planeta", 2)
            startActivity(na)
            this.finish()}

        if (planeta3.isPressed){
            val na = Intent(this, widok_4::class.java)
            na.putExtra("nazwa_rakiety", nazwa_rakiety)
            na.putExtra("planeta", 3)
            startActivity(na)
            this.finish()}

        if (planeta4.isPressed){
            Toast.makeText(this, "Ale ty jesteś na ziemi!", Toast.LENGTH_SHORT).show()}

        if (planeta5.isPressed){
            val na = Intent(this, widok_4::class.java)
            na.putExtra("nazwa_rakiety", nazwa_rakiety)
            na.putExtra("planeta", 5)
            startActivity(na)
            this.finish()}

        if (planeta6.isPressed){
            val na = Intent(this, widok_4::class.java)
            na.putExtra("nazwa_rakiety", nazwa_rakiety)
            na.putExtra("planeta", 6)
            startActivity(na)
            this.finish()}

        if (planeta7.isPressed){
            val na = Intent(this, widok_4::class.java)
            na.putExtra("nazwa_rakiety", nazwa_rakiety)
            na.putExtra("planeta", 7)
            startActivity(na)
            this.finish()}

        if (planeta8.isPressed){
            val na = Intent(this, widok_4::class.java)
            na.putExtra("nazwa_rakiety", nazwa_rakiety)
            na.putExtra("planeta", 8)
            startActivity(na)
            this.finish()}

        if (planeta9.isPressed){
            val na = Intent(this, widok_4::class.java)
            na.putExtra("nazwa_rakiety", nazwa_rakiety)
            na.putExtra("planeta", 9)
            startActivity(na)
            this.finish()}


}}



