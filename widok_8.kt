package com.example.projekt

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_widok_8.*
import kotlin.system.exitProcess

class widok_8 : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFeatureInt(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        this.supportActionBar!!.hide()
        setContentView(R.layout.activity_widok_8)

        val checkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkbox3 = findViewById<CheckBox>(R.id.checkBox3)

        checkbox2.setOnCheckedChangeListener{buttonView, isChecked ->
            checkboxCheck(checkBox3,checkBox2)
        }

        checkbox3.setOnCheckedChangeListener{buttonView, isChecked ->
            checkboxCheck(checkBox2,checkBox3)
        }

        var button1 = findViewById<Button>(R.id.button13)
        button1.setOnClickListener {
            val popup = PopupMenu(this,button1)
            popup.inflate(R.menu.paliwo)
            popup.setOnMenuItemClickListener {
                Toast.makeText(this, it.tooltipText, Toast.LENGTH_LONG).show()
                true
            }
            popup.show()

        }
    }

    private fun checkboxCheck(checkBox2: CheckBox, checkBox3: CheckBox){
        if (checkBox2.isChecked) {
            Toast.makeText(this, "Tylko jedna odpowiedź", Toast.LENGTH_SHORT).show()
            checkBox3.isChecked = false
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
        var jedzenie:Int = intent.getIntExtra("jedzenie",0)
        var szybkosc:Int = intent.getIntExtra("szybkosc",0)


        if (checkBox2.isChecked) {
            val na = Intent(this, widok_9::class.java)
            na.putExtra("zaloga", zaloga)
            na.putExtra("nazwa_rakiety", nazwa_rakiety)
            na.putExtra("planeta", planeta)
            na.putExtra("leki", leki)
            na.putExtra("jedzenie", jedzenie)
            na.putExtra("szybkosc", szybkosc)
            na.putExtra("paliwo", 1)
            startActivity(na)
            this.finish()
        }
        else if (checkBox3.isChecked){
            val na = Intent(this, widok_9::class.java)
            na.putExtra("zaloga", zaloga)
            na.putExtra("nazwa_rakiety", nazwa_rakiety)
            na.putExtra("planeta", planeta)
            na.putExtra("leki", leki)
            na.putExtra("jedzenie", jedzenie)
            na.putExtra("szybkosc", szybkosc)
            na.putExtra("paliwo", 0)
            startActivity(na)
            this.finish()
        }

        else {
            Toast.makeText(this, "Nie zaznaczono odpowiedzi...", Toast.LENGTH_SHORT).show()
        }
}



}
