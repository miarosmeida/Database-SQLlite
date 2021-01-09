package com.example.mydatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    lateinit var userDBHelper:DBHelper
    lateinit var inputemail: EditText
    lateinit var inputfullname: EditText
    lateinit var inputaddress: EditText
    lateinit var inputgender: EditText
    lateinit var inputtelp: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputemail = findViewById(R.id.input_email)
        inputfullname = findViewById(R.id.input_nama)
        inputaddress = findViewById(R.id.input_address)
        inputgender = findViewById(R.id.input_gender)
        inputtelp = findViewById(R.id.input_telp)
        userDBHelper = DBHelper(this)
    }
    fun addData(v: View){
        var emailin = inputemail.text.toString()
        var fullnamein = inputfullname.text.toString()
        var addressin = inputaddress.text.toString()
        var genderin = inputgender.text.toString()
        var telpin = inputtelp.text.toString()
        userDBHelper.insertData(emailin, fullnamein, addressin, genderin, telpin)
        inputemail.setText("")
        inputfullname.setText("")
        inputaddress.setText("")
        inputgender.setText("")
        inputtelp.setText("")
    }
    fun showAll(v: View){
//        var pindah = Intent(this, MainActivity2::class.java)
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }
}