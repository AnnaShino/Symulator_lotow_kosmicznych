package com.example.projekt


import android.annotation.SuppressLint
import android.os.Bundle;
import android.content.Intent
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess


class widok_15 : AppCompatActivity() {
    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFeatureInt(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        this.supportActionBar!!.hide()
        setContentView(R.layout.widok_15)


        val myWebView: WebView = findViewById(R.id.webView)
        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("https://www.nasa.gov/specials/virtual-guest/index.html")

    }


    fun onclick(view: View) {
        val na = Intent(this, widok_14::class.java)
        startActivity(na)
        this.finish()
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
}
