package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldnum = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numEvent(view: android.view.View) {
        if(isNewOp)
           editText.setText("")
        isNewOp = false
        var butclick:String  = editText.text.toString()
        var butselect = view as Button
        when(butselect.id){
            bu1.id -> {butclick += "1"}
            bu2.id -> {butclick += "2"}
            bu3.id -> {butclick += "3"}
            bu4.id -> {butclick += "4"}
            bu5.id -> {butclick += "5"}
            bu6.id -> {butclick += "6"}
            bu7.id -> {butclick += "7"}
            bu8.id -> {butclick += "8"}
            bu9.id -> {butclick += "9"}
            bu0.id -> {butclick += "0"}
            budot.id ->{butclick += "."}
            buAddSub.id -> {butclick += "-$butclick"}

        }
        editText.setText(butclick)
    }

    fun opfun(view: android.view.View) {
        isNewOp = true
        oldnum = editText.text.toString()
        var butselect:Button = view as Button
        when(butselect.id){
            buMul.id -> {op = "x"}
            buDiv.id -> {op = "/"}
            buplus.id -> {op = "+"}
            buMinus.id -> {op = "-"}
        }


    }

    fun eqfun(view: android.view.View) {
        var newnum = editText.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldnum.toDouble() + newnum.toDouble()}
            "-" -> {result = oldnum.toDouble() - newnum.toDouble()}
            "x" -> {result = oldnum.toDouble() * newnum.toDouble()}
            "/" -> {result = oldnum.toDouble() / newnum.toDouble()}
        }
        editText.setText(result.toString())
    }

    fun ACfun(view: android.view.View) {
        editText.setText("0")
        isNewOp = true
    }

    fun percentfun(view: android.view.View) {
        var no:Double = editText.text.toString().toDouble()/100
        editText.setText(no.toString())
        isNewOp = true
    }

}