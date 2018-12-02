package com.lmao.gayyy.collectwordskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var words: ArrayList<CharSequence>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequenceArrayList(LIST, words)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        words = savedInstanceState.getCharSequenceArrayList(LIST)
    }

    fun clickedSave(view: View) {
        val input = findViewById<EditText>(R.id.editText)
        val word = input.text.toString()
        words!!.add(word)
        input.setText("")
    }

    fun clickedClear(view: View) {
        words!!.clear()
    }

    fun clickedShow(view: View) {
        val output = findViewById<TextView>(R.id.textView_message)
        if (words!!.isEmpty()) {
            output.text = "empty"
        }
        output.text = words!!.toString()
    }

    companion object {
        private val LIST = "LIST"
    }
}
