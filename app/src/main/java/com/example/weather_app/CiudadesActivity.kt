package com.example.weather_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ciudades.*
import java.util.*

class CiudadesActivity : AppCompatActivity() {

    companion object {
        const val TAG = "com.example.weather_app.CiudadesActivity.CIUDAD"
    }

    val vancouver = "ciudad-vancouver"
    val montreal = "ciudad-montreal"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        btn_vancouver.setOnClickListener { buttonVancouver() }
        btn_montreal.setOnClickListener { buttonMontreal() }
    }

    fun buttonVancouver() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(TAG, vancouver)
        startActivity(intent)
    }

    fun buttonMontreal() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(TAG, montreal)
        startActivity(intent)
    }
}
