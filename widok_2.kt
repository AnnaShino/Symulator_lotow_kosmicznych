package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_widok_2.*
import kotlin.system.exitProcess

class widok_2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFeatureInt(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        this.supportActionBar!!.hide()
        setContentView(R.layout.activity_widok_2)
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

        val nazwa_rakiety: String = editText2.text.toString()
        if (nazwa_rakiety.isNotEmpty()) {

            val i = Intent(this, widok_3::class.java)
            i.putExtra("nazwa_rakiety", nazwa_rakiety)
            startActivity(i)
            this.finish()

        }
        else {
            Toast.makeText(this, "Zapomniano chyba o czymś..", Toast.LENGTH_SHORT).show()
        }
    }
}
