package com.example.myapplicationv9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplicationv9.ui.theme.MyApplicationV9Theme


class MainActivity : ComponentActivity() {

    private lateinit var editTextPages: EditText
    private lateinit var textViewPricePages: TextView
    private lateinit var textViewDiscount:TextView
    private lateinit var buttonCalculate: Button
    private lateinit var seekBarDiscount: SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate=findViewById(R.id.button_calculate)
        //textViewPricePages=findViewById(R.id.price_pages)
        textViewDiscount=findViewById(R.id.discount)
        seekBarDiscount=findViewById(R.id.seek_bar_discount)
        editTextPages=findViewById(R.id.edit_text_pages)

        seekBarDiscount.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewDiscount.text = "Скидка: $progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        buttonCalculate.setOnClickListener {
            val total = calculateTotal() // Получаем результат вычисления
            // Создаем Intent
            val intent = Intent(this, SecondActivity::class.java)
            // Передаем результат в Intent
            intent.putExtra("result", total.toString())
            // Запускаем вторую активность
            startActivity(intent)
        }
    }
    private fun calculateTotal():Double {
        // Получаем количество страниц и скидку
        val pages = editTextPages.text.toString().toDouble()
        val discount = seekBarDiscount.progress

        // Рассчитываем итоговую сумму с учетом скидки
        var total = pages * 1.0 // Предположим, что стоимость печати 1 рубль за страницу
        total -= (total * discount) / 100
        return total
    }

}
