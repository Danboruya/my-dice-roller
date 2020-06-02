package dev.techpleiades.mydiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage0: ImageView
    private lateinit var diceImage1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage0 = findViewById(R.id.dice_image0)
        diceImage1 = findViewById(R.id.dice_image1)

        val rollButton: Button = findViewById(R.id.roll_button)
        val resetButton: Button = findViewById(R.id.reset_button)
//        val countUpButton: Button = findViewById(R.id.count_up)

        rollButton.setOnClickListener { rollDice() }
        resetButton.setOnClickListener { reset() }
//        countUpButton.setOnClickListener { countUp() }
    }

    private fun rollDice() {
        // toast("Dice Rolled!")
        diceImage0.setImageResource(getRandomDiceImage())
        diceImage1.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage() : Int {
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun reset() {
        // toast("Clear")
        diceImage0.setImageResource(R.drawable.empty_dice)
        diceImage1.setImageResource(R.drawable.empty_dice)
    }

//    private fun countUp() {
//        if (resultText.text == "Hello World!") {
//            toast("Count Up!")
//            resultText.text = "1"
//        } else {
//            var count = resultText.text.toString().toInt()
//            if (count < 6) run {
//                toast("Count Up!")
//                count++
//                resultText.text = count.toString()
//            }
//        }
//    }

    private fun toast(message: String) {
        Toast.makeText(this, message,
            Toast.LENGTH_SHORT).show()
    }
}
