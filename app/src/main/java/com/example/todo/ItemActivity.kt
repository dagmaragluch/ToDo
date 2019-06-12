package com.example.todo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.android.synthetic.main.item_layout_edit.*


class ItemActivity : AppCompatActivity() {

    lateinit var option : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_layout_edit)

        button.setOnClickListener { v -> onClick(v) }
    }


    fun onClick(view: View){
        option = intent.getStringExtra("option")

        val text = findViewById<View>(R.id.editTitle) as EditText
        val eTitle = text.text.toString()

        val text2 = findViewById<View>(R.id.editDeadline) as EditText
        val eDeadline = text2.text.toString()

        val text3 = findViewById<View>(R.id.editPriority) as EditText
        val ePriority = text3.text.toString()

        val finalString : String
        finalString = "$option;;$eTitle;;$eDeadline;;$ePriority"

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(Intent.EXTRA_TEXT, finalString)
        setResult(Activity.RESULT_OK, intent)
//        startActivity(intent)
        finish()
    }


}