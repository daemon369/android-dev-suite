package me.daemon.devsuite.demo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<AppCompatEditText>(R.id.input)
        findViewById<AppCompatTextView>(R.id.btn).setOnClickListener {
            val url = input.editableText?.toString()
            if (url.isNullOrEmpty()) {
                Toast.makeText(this, "URL不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            startActivity(Intent(this, WebViewActivity::class.java).apply {
                putExtra("url", url)
            })
        }
    }
}