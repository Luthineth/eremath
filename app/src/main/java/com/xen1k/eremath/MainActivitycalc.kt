package com.xen1k.eremath

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

    class MainActivitycalc : AppCompatActivity() {

        // TextView used to display the input and output
        private lateinit var txtInput: TextView

        // Represent whether the lastly pressed key is numeric or not
        private var lastNumeric: Boolean = false

        // Represent that current state is in error or not
        private var stateError: Boolean = false

        // If true, do not allow to add another DOT
        private var lastDot: Boolean = false

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_maincalc)
            txtInput = findViewById(R.id.txtInput)
        }

        /**
         * Append the Button.text to the TextView
         */
        fun onDigit(view: View) {
            if (stateError) {
                // If current state is Error, replace the error message
                txtInput.text = (view as Button).text
                stateError = false
            } else {
                // If not, already there is a valid expression so append to it
                txtInput.append((view as Button).text)
            }
            // Set the flag
            lastNumeric = true
        }

        /**
         * Append . to the TextView
         */
        fun onDecimalPoint(view: View) {
            if (lastNumeric && !stateError && !lastDot) {
                txtInput.append(".")
                lastNumeric = false
                lastDot = true
            }
        }

        /**
         * Append +,-,*,/ operators to the TextView
         */
        fun onOperator(view: View) {
            if (lastNumeric && !stateError) {
                txtInput.append((view as Button).text)
                lastNumeric = false
                lastDot = false    // Reset the DOT flag
            }
        }


        /**
         * Clear the TextView
         */
        fun onClear(view: View) {
            this.txtInput.text = ""
            lastNumeric = false
            stateError = false
            lastDot = false
        }

        /**
         * Delete one symbol
         */

        fun onDel(view: View) {
            val string = txtInput.text.toString()
            if (string.isNotEmpty()) {
                txtInput.text = string.substring(0, string.length - 1)
            } else {
                this.txtInput.text = ""
                lastNumeric = false
                stateError = false
                lastDot = false
            }
        }

        /**
         * Brackets
         */

        fun onBracket1(view: View) {
            val string = "("
            txtInput.append(string)
        }

        fun onBracket2(view: View) {
            val string = ")"
            val string1 = "("
            val txt = txtInput.text.toString()
            if (txt.contains(string1)) {
                txtInput.append(string)
            }
        }


        /**
         * Calculate the output using Exp4j
         */
        fun onEqual(view: View) {
            // If the current state is error, nothing to do.
            // If the last input is a number only, solution can be found.
            val txt1 = txtInput.text.toString()
            val string1 = "("
            val string2 = ")"

            val pattern1 = Regex("[" + string1 + "]")
            val matcher1 = txt1
            val count1 = pattern1.findAll(matcher1).count()

            val pattern2 = Regex("[" + string2 + "]")
            val matcher2 = txt1
            val count2 = pattern2.findAll(matcher2).count()

            if (count1 == count2) {
                if (lastNumeric && !stateError) {
                    // Read the expression
                    val txt = txtInput.text.toString()
                    // Create an Expression (A class from exp4j library)
                    val expression = ExpressionBuilder(txt).build()
                    try {
                        // Calculate the result and display
                        val result = expression.evaluate()
                        txtInput.text = result.toString()
                        lastDot = true // Result contains a dot
                    } catch (ex: ArithmeticException) {
                        // Display an error message
                        txtInput.text = "Error"
                        stateError = true
                        lastNumeric = false
                    }
                }
            } else {txtInput.text="Invalid format"}
        }
    }