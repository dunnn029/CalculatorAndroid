package com.example.mysimplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val textView: TextView = findViewById(R.id.textview)
//        val text = textView.text.toString()
//        val textLength = text.length
//        val ceButton: Button = findViewById(R.id.ce)
//        val cButton: Button = findViewById(R.id.c)
//        val bsButton: Button = findViewById(R.id.bs)
//        val divideButton: Button = findViewById(R.id.divide)
//        val multiplyButton: Button = findViewById(R.id.multiply)
//        val minusButton: Button = findViewById(R.id.minus)
//        val plusButton: Button = findViewById(R.id.plus)
//        val button9: Button = findViewById(R.id.btn9)
//        val button8: Button = findViewById(R.id.btn8)
//        val button7: Button = findViewById(R.id.btn7)
//        val button6: Button = findViewById(R.id.btn6)
//        val button5: Button = findViewById(R.id.btn5)
//        val button4: Button = findViewById(R.id.btn4)
//        val button3: Button = findViewById(R.id.btn3)
//        val button2: Button = findViewById(R.id.btn2)
//        val button1: Button = findViewById(R.id.btn1)
//        val button0: Button = findViewById(R.id.btn0)
//        val oppositeButton: Button = findViewById(R.id.btn_opposite)
//        val dotButton: Button = findViewById(R.id.dot)
//        val equalButton: Button = findViewById(R.id.equal)

    }
    private var firstValue: String = ""
    private var secondValue: String = ""
    private var sign: String = ""

    fun buttonClick(view: View) {
        val button: Button = view as Button;
        val data: String = button.text.toString()
        val textView: TextView = findViewById(R.id.textview)

        val screenText = textView.text.toString()
        lateinit var input: String


        when (data) {
            "CE" -> {
                if (sign == "")
                    firstValue = ""
                input = "0"
            }

            "C" -> {
                firstValue = ""
                secondValue = ""
                sign = ""
                input = "0"
            }

            "BS" -> {
                input = if (textView.text.length > 1) {
                    val backspace: String = screenText.substring(0, screenText.length - 1)
                    backspace
                } else "0"
            }

            "+/-" -> {
                val opposite = 0 - screenText.toInt()
                input = opposite.toString()
            }

            "+" -> {
                if (firstValue == "") firstValue = screenText
                input = if (sign == "") {
                    sign = "+"
                    screenText
                }
                else {
                    secondValue = screenText
                    val ans = solve()

                    firstValue = ans
                    sign = "+"
                    secondValue = ""
                    ans
                }
            }

            "-" -> {
                if (firstValue == "") firstValue = screenText
                input = if (sign == "") {
                    sign = "-"
                    screenText
                }
                else {
                    secondValue = screenText
                    val ans = solve()

                    firstValue = ans
                    sign = "-"
                    secondValue = ""
                    ans
                }
            }

            "x" -> {
                if (firstValue == "") firstValue = screenText
                input = if (sign == "") {
                    sign = "x"
                    screenText
                }
                else {
                    secondValue = screenText
                    val ans = solve()

                    firstValue = ans
                    sign = "x"
                    secondValue = ""
                    ans
                }
            }

            "/" -> {
                if (firstValue == "") firstValue = screenText
                input = if (sign == "") {
                    sign = "/"
                    screenText
                }
                else {
                    secondValue = screenText
                    val ans = solve()

                    firstValue = ans
                    sign = "/"
                    secondValue = ""
                    ans
                }
            }

            "=" -> {
                secondValue = screenText
                input = if (firstValue == "" || secondValue == "" || sign == "") screenText
                else {
                    val ans = solve()

                    firstValue = ""
                    sign = ""
                    secondValue = ""
                    ans
                }
            }

            else -> {
                input = if (screenText == "0" || screenText == firstValue || firstValue == "") data
                else screenText + data
            }
        }
        textView.text = input
    }
    private fun solve(): String {
        when (sign) {
            "+" -> {
                val ans = firstValue.toDouble() + secondValue.toDouble()
                return ans.toString()
            }

            "-" -> {
                val ans = firstValue.toDouble() - secondValue.toDouble()
                return ans.toString()
            }

            "x" -> {
                val ans = firstValue.toDouble() * secondValue.toDouble()
                return ans.toString()
            }

            else -> {
                val ans = firstValue.toDouble() / secondValue.toDouble()
                return ans.toString()
            }
        }
    }
}