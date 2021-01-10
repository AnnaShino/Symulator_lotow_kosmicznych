package com.example.projekt

import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle;
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity;
import java.io.File
import java.io.FileInputStream
import java.time.LocalDate
import java.time.LocalTime
import kotlin.system.exitProcess
import kotlin.time.ExperimentalTime


class widok_9 : AppCompatActivity() {

    @ExperimentalTime
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFeatureInt(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        this.supportActionBar!!.hide()
        setContentView(R.layout.activity_widok_9)

        var postep = obliczenia()
        var punkty_rankingowe = ranking()
        var data = LocalDate.now()
        var godzina = LocalTime.now().hour
        var minuta = LocalTime.now().minute
        var plik_zapisu = filesDir
        val rankingi = File(plik_zapisu, "ranking")
        if (minuta <= 9){
            rankingi.appendText("  // $data // $godzina : 0$minuta //\n-> " +
                    "$punkty_rankingowe punktów dopasowania\n-> $postep punktów postępu misji \n\n")
        }
        else {
            rankingi.appendText("  // $data // $godzina : $minuta //\n-> " +
                    "$punkty_rankingowe punktów dopasowania\n-> $postep punktów postępu misji \n\n")
        }
        val pokaz = FileInputStream(rankingi).bufferedReader().use { it.readText() }.toString()




        val button = findViewById<Button>(R.id.button4)

        buttonApear(button)

        var ring = MediaPlayer.create(this, R.raw.rakieta);
        ring.start()
    }


    private fun buttonApear(button: Button) {
        object : CountDownTimer(15000, 15000) {
            override fun onFinish() {
                button.visibility = View.VISIBLE
            }

            override fun onTick(millisUntilFinished: Long) {

            }


        }.start()
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

    fun obliczenia(): Int {
        var planeta: Int = intent.getIntExtra("planeta", 0)
        var zaloga = intent.getIntExtra("zaloga",0)
        var leki: Int = intent.getIntExtra("leki", 0)
        var jedzenie: Int = intent.getIntExtra("jedzenie",0)
        var szybkosc: Int = intent.getIntExtra("szybkosc",0)
        var paliwo: Int = intent.getIntExtra("paliwo", 0)


        var punkty = 0
        var czas_sumaryczny1 = 0

        if (zaloga == 0) {
            punkty += 0
        } else if ((zaloga >= 1) and (zaloga <= 3)) {
            punkty += 2
        } else if ((zaloga >= 4) and (zaloga <= 7)) {
            punkty += 2
        } else if ((zaloga >= 8) and (zaloga <= 10)) {
            punkty += 2
        } else if (zaloga >= 11) {
            punkty += 0
        }


        if (leki == 0) {
            punkty += 0
        } else if (leki == 1) {
            punkty += 1
        }

        if ((szybkosc <= 7999) and (paliwo == 0)) {
            punkty += 0
        }
        else if ((szybkosc >= 8000) and (paliwo == 1)) {
            punkty += 2

            if (planeta == 1) {
                var odleglosc = 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty += -100
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 2) {
                var odleglosc = 149504000 - 57740000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty += 1
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 3) {
                var odleglosc = 149504000 - 108141000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty += 1
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 5) {
                var odleglosc = 227798000 - 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty += 1
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 6) {
                var odleglosc = 777840000 - 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty += 1
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 7) {
                var odleglosc = 1426100000 - 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty += 1
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 8) {
                var odleglosc = 2867830000 - 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty += 1
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 9) {
                var odleglosc = 4493650000 - 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty += 1
                czas_sumaryczny1 == czas_sumaryczny
            }

        } else {
            punkty += 0
        }


        var jedzenie_gotowe = jedzenie * 0.2
        var jedzenie_dla_jednostki = jedzenie_gotowe / zaloga
        var zapasy = jedzenie_dla_jednostki / czas_sumaryczny1

        if (zapasy <= 0.13) {
            punkty += 0
        }
        else if (zapasy >= 0.14)  {
            punkty += 1
        }


        return punkty
    }


    fun ranking(): Int {
        var planeta: Int = intent.getIntExtra("planeta", 0)
        var zaloga = intent.getIntExtra("zaloga",0)
        var leki: Int = intent.getIntExtra("leki", 0)
        var jedzenie: Int = intent.getIntExtra("jedzenie",0)
        var szybkosc: Int = intent.getIntExtra("szybkosc",0)
        var paliwo: Int = intent.getIntExtra("paliwo", 0)


        var punkty_rankingowe = 0
        var czas_sumaryczny1 = 0

        if (zaloga == 0) {
            punkty_rankingowe +=0
        } else if ((zaloga >= 1) and (zaloga <= 3)) {
            punkty_rankingowe += 5
            punkty_rankingowe += 10
        } else if ((zaloga >= 8) and (zaloga <= 10)) {
            punkty_rankingowe += 5
        } else if (zaloga >= 11) {
            punkty_rankingowe +=0
        }


        if (leki == 0) {
            punkty_rankingowe +=0
        } else if (leki == 1) {
            punkty_rankingowe +=10
        }

        if ((szybkosc <= 7999) and (paliwo == 0)) {
            punkty_rankingowe +=0
        }
        else if ((szybkosc >= 8000) and (paliwo == 1)) {

            if (planeta == 1) {
                var odleglosc = 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty_rankingowe += -50
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 2) {
                var odleglosc = 149504000 - 57740000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty_rankingowe += 5
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 3) {
                var odleglosc = 149504000 - 108141000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty_rankingowe += 10
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 5) {
                var odleglosc = 227798000 - 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty_rankingowe += 10
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 6) {
                var odleglosc = 777840000 - 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty_rankingowe +=5
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 7) {
                var odleglosc = 1426100000 - 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty_rankingowe +=5
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 8) {
                var odleglosc = 2867830000 - 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty_rankingowe +=5
                czas_sumaryczny1 == czas_sumaryczny
            } else if (planeta == 9) {
                var odleglosc = 4493650000 - 149504000
                var czas = ((odleglosc / szybkosc) / 24) * 2
                var czas_sumaryczny = (czas + (czas * 0.1)).toInt()
                punkty_rankingowe +=0
                czas_sumaryczny1 == czas_sumaryczny
            }

            if ((szybkosc >= 8000) and (szybkosc <= 9000)){
                punkty_rankingowe +=10}
            else if ((szybkosc >= 9001) and (szybkosc <= 10000)){
                punkty_rankingowe +=15}
            else if ((szybkosc >= 10001) and (szybkosc <= 13000)) {
                punkty_rankingowe +=20}
            else {
                punkty_rankingowe +=0
            }

        } else {
            punkty_rankingowe += 0
        }

        var jedzenie_gotowe = jedzenie * 0.2
        var jedzenie_dla_jednostki = jedzenie_gotowe / zaloga
        var zapasy = jedzenie_dla_jednostki / czas_sumaryczny1

        if (zapasy <= 0.13) {
            punkty_rankingowe += 0
        }
        else if ((zapasy >= 0.14) and (zapasy <= 0.2))  {
            punkty_rankingowe +=10
        }
        else if ((zapasy >= 0.21) and (zapasy <= 0.25)) {
            punkty_rankingowe += 5
        }
        else if ((zapasy >= 0.26) and (zapasy <= 0.35)) {
            punkty_rankingowe += 0
        }
        else {
            punkty_rankingowe += 0
        }


        return punkty_rankingowe
    }


    fun nextStep(view: View) {

        var punkty = obliczenia()
        when {
            ((punkty <= 4) and (punkty >=0)) -> {
                val i = Intent(this, widok_10::class.java)
                i.putExtra("punkty", punkty)
                startActivity(i)
                this.finish()
            }
            (punkty == 5) or (punkty == 6) -> {
                val i = Intent(this, widok_12::class.java)
                i.putExtra("punkty", punkty)
                startActivity(i)
                this.finish()
            }
            punkty == 7 -> {
                val i = Intent(this, widok_13::class.java)
                i.putExtra("punkty", punkty)
                startActivity(i)
                this.finish()
            }
            (punkty < -1) -> {
                val i = Intent(this, widok_11::class.java)
                i.putExtra("punkty", punkty)
                startActivity(i)
                this.finish()

            }
        }
    }

}


