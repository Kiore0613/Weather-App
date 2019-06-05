package com.example.weather_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ciudades.*

class CiudadesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        btn_vancouver.setOnClickListener { buttonVancouver() }

        btn_montreal.setOnClickListener { buttonMontreal() }
    }

    fun buttonVancouver() {
        Toast.makeText(this, "vancouver", Toast.LENGTH_LONG).show()
    }

    fun buttonMontreal() {
        Toast.makeText(this, "montreal", Toast.LENGTH_LONG).show()
    }
}
