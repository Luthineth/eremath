package com.xen1k.eremath

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1.setOnClickListener{
            vvod.setText(vvod.text.toString() + b1.text.toString(), TextView.BufferType.EDITABLE)
        }
    }
}
