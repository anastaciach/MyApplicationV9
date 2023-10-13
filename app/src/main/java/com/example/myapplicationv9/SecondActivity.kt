package com.example.myapplicationv9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.app.Activity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Найдите TextView в макете
        val resultTextView = findViewById<TextView>(R.id.price_pages)

        // Получите результат из Intent
        val result = intent.getStringExtra("result")

        // Установите результат в TextView
        resultTextView.text = "Сумма заказа = $result"
    }
}