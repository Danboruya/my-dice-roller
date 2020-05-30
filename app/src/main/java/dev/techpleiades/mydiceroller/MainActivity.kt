package dev.techpleiades.mydiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val resetButton: Button = findViewById(R.id.reset_button)
        val countUpButton: Button = findViewById(R.id.count_up)

        rollButton.setOnClickListener { rollDice() }
        resetButton.setOnClickListener { reset() }
        countUpButton.setOnClickListener { countUp() }
    }

    private fun rollDice() {
        toast("Dice Rolled!")
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = (1..6).random()

        resultText.text = randomInt.toString()
    }

    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)
        toast("Reset")
        resultText.text = "0"
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        if (resultText.text == "Hello World!") {
            toast("Count Up!")
            resultText.text = "1"
        } else {
            var count = resultText.text.toString().toInt()
            if (count < 6) run {
                toast("Count Up!")
                count++
                resultText.text = count.toString()
            }
        }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message,
            Toast.LENGTH_SHORT).show()
    }
}
