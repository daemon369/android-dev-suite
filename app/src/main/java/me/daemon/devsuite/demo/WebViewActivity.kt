package me.daemon.devsuite.demo

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity(R.layout.activity_web_view) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val url = intent?.getStringExtra("url")
        val webView = findViewById<WebView>(R.id.web_view)
        url?.apply {
            webView.loadUrl(this)
        }
    }

}